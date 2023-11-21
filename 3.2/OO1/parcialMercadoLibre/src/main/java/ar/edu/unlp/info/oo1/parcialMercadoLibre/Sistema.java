package ar.edu.unlp.info.oo1.parcialMercadoLibre;

import java.util.List;
import java.util.ArrayList;

public class Sistema {
	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	private List<Pedido> pedidos;
	
	public Sistema() {
		this.vendedores = new ArrayList<Vendedor>();
		this.clientes = new ArrayList<Cliente>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public void registrarVendedor(String nombre, String dir) {
		Vendedor v = new Vendedor(nombre, dir);
		this.vendedores.add(v);
	}
	public Vendedor buscarVendedor(String nombre) {
		return this.vendedores.stream()
				.filter(v -> v.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}
	
	public void registrarCliente(String nombre, String dir) {
		Cliente c = new Cliente(nombre, dir);
		this.clientes.add(c);
	}
	public Cliente buscarCliente(String nombre) {
		return this.clientes.stream()
				.filter(c -> c.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}
	
	public void registrarProducto(String nombre, String desc, double precio, int stock, Vendedor v) {
		Producto prod = new Producto(nombre, desc, precio, stock);
		v.agregarProducto(prod);
	}
	
	public List<Producto> buscar(String nombre){
		List<Producto> prodsBuscados = new ArrayList<Producto>();
		for(Vendedor v : this.vendedores) {
			v.buscarProductos(nombre).stream()
			.map(p -> prodsBuscados.add(p));
		}
		return prodsBuscados;
	}
	
	
	public void crearPedido(Cliente cli, Vendedor v, Producto prod, int cant, Pago pago, Envio envio) {
		Pedido p = new Pedido(cant, cli, prod, pago, envio);
		if(p.registrarPedido()) {
			this.pedidos.add(p);
		}
	}
}
