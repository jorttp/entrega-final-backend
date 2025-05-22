package co.edu.co.lilfac.entity;

import java.text.ParseException;
import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class FacturaEntity {
	private UUID id;
	private String codigo;
	private String fechaGeneracion;
	private float costoTotal;
	private EmpresaEntity empresa;
	private EmpleadoEntity empleado;
	private ClienteEntity cliente;
	private CostoAdicionalEntity costoAdicional;
	private PedidoEntity pedido;
	
	public FacturaEntity() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigo(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaGeneracion(fechaGeneracion);
		setCostoTotal(UtilNumerico.getInstance().obtenerValorDefecto());
		setEmpresa(EmpresaEntity.obtenerValorDefecto());
		setEmpleado(EmpleadoEntity.obtenerValorDefecto());
		setCliente(ClienteEntity.obtenerValorDefecto());
		setCostoAdicional(CostoAdicionalEntity.obtenerValorDefecto());
		setPedido(PedidoEntity.obtenerValorDefecto());
	}
	
	public FacturaEntity(final UUID id, final String codigo, final String fechaGeneracion, final float costoTotal, final EmpresaEntity empresa, final EmpleadoEntity empleado, final ClienteEntity cliente, final CostoAdicionalEntity costoAdicional, final PedidoEntity pedido) throws ParseException {
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigo);
	}

	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(fechaGeneracion);
	}

	public float getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(float costoTotal) {
		this.costoTotal = UtilFloat.obtenerValorDefecto(costoTotal);
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = EmpresaEntity.obtenerValorDefecto(empresa);
	}

	public EmpleadoEntity getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoEntity empleado) {
		this.empleado = EmpleadoEntity.obtenerValorDefecto(empleado);
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = ClienteEntity.obtenerValorDefecto(cliente);
	}

	public CostoAdicionalEntity getCostoAdicional() {
		return costoAdicional;
	}

	public void setCostoAdicional(CostoAdicionalEntity costoAdicional) {
		this.costoAdicional = CostoAdicionalEntity.obtenerValorDefecto(costoAdicional);
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = PedidoEntity.obtenerValorDefecto(pedido);
	}

}

