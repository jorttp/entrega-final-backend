package co.edu.co.lilfac.businesslogic.businesslogic.domain;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilObjeto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class FacturaDomain {
	private UUID id;
	private String codigo;
	private String fechaGeneracion;
	private float costoTotal;
	private EmpresaDomain empresa;
	private EmpleadoDomain empleado;
	private ClienteDomain cliente;
	private CostoAdicionalDomain costoAdicional;
	private PedidoDomain pedido;
	
	FacturaDomain() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigo(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaGeneracion(UtilTexto.getInstance().obtenerValorDefecto());
		setCostoTotal(UtilNumerico.getInstance().obtenerValorDefecto());
		setEmpresa(EmpresaDomain.obtenerValorDefecto());
		setEmpleado(EmpleadoDomain.obtenerValorDefecto());
		setCliente(ClienteDomain.obtenerValorDefecto());
		setCostoAdicional(CostoAdicionalDomain.obtenerValorDefecto());
		setPedido(PedidoDomain.obtenerValorDefecto());
	}
	
	public FacturaDomain(final UUID id, final String codigo, final String fechaGeneracion, final float costoTotal, final EmpresaDomain empresa, final EmpleadoDomain empleado, final ClienteDomain cliente, final CostoAdicionalDomain costoAdicional, final PedidoDomain pedido) {
		setId(id);
		setCodigo(codigo);
		setFechaGeneracion(fechaGeneracion);
		setCostoTotal(costoTotal);
		setEmpresa(empresa);
		setEmpleado(empleado);
		setCliente(cliente);
		setCostoAdicional(costoAdicional);
		setPedido(pedido);
	}
	
	static FacturaDomain obtenerValorDefecto() {
		return new FacturaDomain();
	}
	
	public static FacturaDomain obtenerValorDefecto(final FacturaDomain factura ) {
		return UtilObjeto.getInstance().obtenerValorDefecto(factura, obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
		this.codigo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigo);
	}

	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	private void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(fechaGeneracion);
	}

	public float getCostoTotal() {
		return costoTotal;
	}

	private void setCostoTotal(float costoTotal) {
		this.costoTotal = UtilFloat.obtenerValorDefecto(costoTotal);
	}

	public EmpresaDomain getEmpresa() {
		return empresa;
	}

	private void setEmpresa(EmpresaDomain empresa) {
		this.empresa = EmpresaDomain.obtenerValorDefecto(empresa);
	}

	public EmpleadoDomain getEmpleado() {
		return empleado;
	}

	private void setEmpleado(EmpleadoDomain empleado) {
		this.empleado = EmpleadoDomain.obtenerValorDefecto(empleado);
	}

	public ClienteDomain getCliente() {
		return cliente;
	}

	private void setCliente(ClienteDomain cliente) {
		this.cliente = ClienteDomain.obtenerValorDefecto(cliente);
	}

	public CostoAdicionalDomain getCostoAdicional() {
		return costoAdicional;
	}

	private void setCostoAdicional(CostoAdicionalDomain costoAdicional) {
		this.costoAdicional = CostoAdicionalDomain.obtenerValorDefecto(costoAdicional);
	}

	public PedidoDomain getPedido() {
		return pedido;
	}

	private void setPedido(PedidoDomain pedido) {
		this.pedido = PedidoDomain.obtenerValorDefecto(pedido);
	}

}

