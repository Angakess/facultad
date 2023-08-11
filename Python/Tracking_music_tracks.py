import xml.etree.ElementTree as ET
import sqlite3

conn = sqlite3.connect('TrackingTracks.sqlite')
cur = conn.cursor()

cur.executescript('''
DROP TABLE IF EXISTS Artists;
DROP TABLE IF EXISTS Albums;
DROP TABLE IF EXISTS Genres;
DROP TABLE IF EXISTS Tracks;

CREATE TABLE Artists (
    id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    Artist    TEXT UNIQUE
);

CREATE TABLE Genres (
    id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    Genre    TEXT UNIQUE
);

CREATE TABLE Albums (
    id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    artist_id  INTEGER,
    Album   TEXT UNIQUE
);

CREATE TABLE Tracks (
    id  INTEGER NOT NULL PRIMARY KEY
        AUTOINCREMENT UNIQUE,
    Track TEXT  UNIQUE,
    album_id  INTEGER,
    genre_id  INTEGER,
    len INTEGER
);
''')

fh = input('Enter file:')
def lookup(d, key):
    found = False
    for child in d:
        if found : return child.text
        if child.tag == 'key' and child.text == key :
            found = True
    return None

stuff = ET.parse(fh)
all = stuff.findall('dict/dict/dict')
for entry in all:
    if ( lookup(entry, 'Track ID') is None ) : continue

    name = lookup(entry, 'Name')
    artist = lookup(entry, 'Artist')
    album = lookup(entry, 'Album')
    genre = lookup(entry, 'Genre')
    length = lookup(entry, 'Total Time')

    if name is None or artist is None or album is None or genre is None :
        continue

    cur.execute('''INSERT OR IGNORE INTO Artists (Artist)
        VALUES ( ? )''', ( artist, ) )
    cur.execute('SELECT id FROM Artists WHERE Artist = ? ', (artist, ))
    artist_id = cur.fetchone()[0]

    cur.execute('''INSERT OR IGNORE INTO Genres (Genre)
       VALUES ( ? )''', ( genre, ) )
    cur.execute('SELECT id FROM Genres WHERE Genre = ? ', (genre, ))
    genre_id = cur.fetchone()[0]

    cur.execute('''INSERT OR IGNORE INTO Albums (Album, artist_id)
        VALUES ( ?, ? )''', ( album, artist_id ) )
    cur.execute('SELECT id FROM Albums WHERE Album = ? ', (album, ))
    album_id = cur.fetchone()[0]

    cur.execute('''INSERT OR REPLACE INTO Tracks
        (Track, album_id, genre_id, len)
        VALUES ( ?, ?, ?, ? )''',
        ( name, album_id, genre_id, length ) )

    conn.commit()
