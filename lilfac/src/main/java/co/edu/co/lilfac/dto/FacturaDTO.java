package co.edu.co.lilfac.dto;

import java.util.UUID;

import co.edu.co.lilfac.crosscutting.utilitarios.UtilFloat;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilNumerico;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilTexto;
import co.edu.co.lilfac.crosscutting.utilitarios.UtilUUID;

public class FacturaDTO {
	private UUID id;
	private String codigo;
	private String fechaGeneracion;
	private float costoTotal;
	private EmpresaDTO empresa;
	private EmpleadoDTO empleado;
	private ClienteDTO cliente;
	private CostoAdicionalDTO costoAdicional;
	private PedidoDTO pedido;
	
	public FacturaDTO() {
		setId(UtilUUID.obtenerValorDefecto());
		setCodigo(UtilTexto.getInstance().obtenerValorDefecto());
		setFechaGeneracion(UtilTexto.getInstance().obtenerValorDefecto());
		setCostoTotal(UtilNumerico.getInstance().obtenerValorDefecto());
		setEmpresa(EmpresaDTO.obtenerValorDefecto());
		setEmpleado(EmpleadoDTO.obtenerValorDefecto());
		setCliente(ClienteDTO.obtenerValorDefecto());
		setCostoAdicional(CostoAdicionalDTO.obtenerValorDefecto());
		setPedido(PedidoDTO.obtenerValorDefecto());
	}
	
	public FacturaDTO(final UUID id, final String codigo, final String fechaGeneracion, final float costoTotal, final EmpresaDTO empresa, final EmpleadoDTO empleado, final ClienteDTO cliente, final CostoAdicionalDTO costoAdicional, final PedidoDTO pedido) {
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

	public FacturaDTO setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		return this;
	}

	public String getCodigo() {
		return codigo;
	}

	public FacturaDTO setCodigo(String codigo) {
		this.codigo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(codigo);
		return this;
	}

	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	public FacturaDTO setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(fechaGeneracion);
		return this;
	}

	public float getCostoTotal() {
		return costoTotal;
	}

	public FacturaDTO setCostoTotal(float costoTotal) {
		this.costoTotal = UtilFloat.obtenerValorDefecto(costoTotal);
		return this;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public FacturaDTO setEmpresa(EmpresaDTO empresa) {
		this.empresa = EmpresaDTO.obtenerValorDefecto(empresa);
		return this;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public FacturaDTO setEmpleado(EmpleadoDTO empleado) {
		this.empleado = EmpleadoDTO.obtenerValorDefecto(empleado);
		return this;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public FacturaDTO setCliente(ClienteDTO cliente) {
		this.cliente = ClienteDTO.obtenerValorDefecto(cliente);
		return this;
	}

	public CostoAdicionalDTO getCostoAdicional() {
		return costoAdicional;
	}

	public FacturaDTO setCostoAdicional(CostoAdicionalDTO costoAdicional) {
		this.costoAdicional = CostoAdicionalDTO.obtenerValorDefecto(costoAdicional);
		return this;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public FacturaDTO setPedido(PedidoDTO pedido) {
		this.pedido = PedidoDTO.obtenerValorDefecto(pedido);
		return this;
	}

}

