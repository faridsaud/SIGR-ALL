package ec.edu.epn.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQueries({
	@NamedQuery(name="Usuariorol.findAll", query="SELECT u FROM Usuariorol u"),
	@NamedQuery(name="Usuariorol.findAllbyRol", query="SELECT u FROM Usuariorol u WHERE u.rol.rolNombre = :rolnombre")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USUARIO_ID")
	private int usuarioId;

	@Column(name="USUARIO_APELLIDO")
	private String usuarioApellido;

	@Column(name="USUARIO_CEDULA")
	private String usuarioCedula;

	@Column(name="USUARIO_CIUDAD")
	private String usuarioCiudad;

	@Column(name="USUARIO_CONTRASENA")
	private String usuarioContrasena;

	@Column(name="USUARIO_CORREO_ELECTRONICO")
	private String usuarioCorreoElectronico;

	@Column(name="USUARIO_ESTADO_BORRADO")
	private int usuarioEstadoBorrado;

	@Column(name="USUARIO_NOMBRE")
	private String usuarioNombre;

	@Column(name="USUARIO_USERNAME")
	private String usuarioUsername;

	//bi-directional many-to-one association to Calibracion
	@OneToMany(mappedBy="usuario")
	private List<Calibracion> calibracions;

	//bi-directional many-to-one association to Prueba
	@OneToMany(mappedBy="usuario")
	private List<Prueba> pruebas;

	//bi-directional many-to-one association to Reactivo
	@OneToMany(mappedBy="usuario")
	private List<Reactivo> reactivos;

	//bi-directional many-to-one association to Usuariocarrera
	@OneToMany(mappedBy="usuario")
	private List<Usuariocarrera> usuariocarreras;

	//bi-directional many-to-one association to Usuariorol
	@OneToMany(mappedBy="usuario")
	private List<Usuariorol> usuariorols;

	//bi-directional many-to-one association to Validacion
	@OneToMany(mappedBy="usuario")
	private List<Validacion> validacions;

	public Usuario() {
	}

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuarioApellido() {
		return this.usuarioApellido;
	}

	public void setUsuarioApellido(String usuarioApellido) {
		this.usuarioApellido = usuarioApellido;
	}

	public String getUsuarioCedula() {
		return this.usuarioCedula;
	}

	public void setUsuarioCedula(String usuarioCedula) {
		this.usuarioCedula = usuarioCedula;
	}

	public String getUsuarioCiudad() {
		return this.usuarioCiudad;
	}

	public void setUsuarioCiudad(String usuarioCiudad) {
		this.usuarioCiudad = usuarioCiudad;
	}

	public String getUsuarioContrasena() {
		return this.usuarioContrasena;
	}

	public void setUsuarioContrasena(String usuarioContrasena) {
		this.usuarioContrasena = usuarioContrasena;
	}

	public String getUsuarioCorreoElectronico() {
		return this.usuarioCorreoElectronico;
	}

	public void setUsuarioCorreoElectronico(String usuarioCorreoElectronico) {
		this.usuarioCorreoElectronico = usuarioCorreoElectronico;
	}

	public int getUsuarioEstadoBorrado() {
		return this.usuarioEstadoBorrado;
	}

	public void setUsuarioEstadoBorrado(int usuarioEstadoBorrado) {
		this.usuarioEstadoBorrado = usuarioEstadoBorrado;
	}

	public String getUsuarioNombre() {
		return this.usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getUsuarioUsername() {
		return this.usuarioUsername;
	}

	public void setUsuarioUsername(String usuarioUsername) {
		this.usuarioUsername = usuarioUsername;
	}

	public List<Calibracion> getCalibracions() {
		return this.calibracions;
	}

	public void setCalibracions(List<Calibracion> calibracions) {
		this.calibracions = calibracions;
	}

	public Calibracion addCalibracion(Calibracion calibracion) {
		getCalibracions().add(calibracion);
		calibracion.setUsuario(this);

		return calibracion;
	}

	public Calibracion removeCalibracion(Calibracion calibracion) {
		getCalibracions().remove(calibracion);
		calibracion.setUsuario(null);

		return calibracion;
	}

	public List<Prueba> getPruebas() {
		return this.pruebas;
	}

	public void setPruebas(List<Prueba> pruebas) {
		this.pruebas = pruebas;
	}

	public Prueba addPrueba(Prueba prueba) {
		getPruebas().add(prueba);
		prueba.setUsuario(this);

		return prueba;
	}

	public Prueba removePrueba(Prueba prueba) {
		getPruebas().remove(prueba);
		prueba.setUsuario(null);

		return prueba;
	}

	public List<Reactivo> getReactivos() {
		return this.reactivos;
	}

	public void setReactivos(List<Reactivo> reactivos) {
		this.reactivos = reactivos;
	}

	public Reactivo addReactivo(Reactivo reactivo) {
		getReactivos().add(reactivo);
		reactivo.setUsuario(this);

		return reactivo;
	}

	public Reactivo removeReactivo(Reactivo reactivo) {
		getReactivos().remove(reactivo);
		reactivo.setUsuario(null);

		return reactivo;
	}

	public List<Usuariocarrera> getUsuariocarreras() {
		return this.usuariocarreras;
	}

	public void setUsuariocarreras(List<Usuariocarrera> usuariocarreras) {
		this.usuariocarreras = usuariocarreras;
	}

	public Usuariocarrera addUsuariocarrera(Usuariocarrera usuariocarrera) {
		getUsuariocarreras().add(usuariocarrera);
		usuariocarrera.setUsuario(this);

		return usuariocarrera;
	}

	public Usuariocarrera removeUsuariocarrera(Usuariocarrera usuariocarrera) {
		getUsuariocarreras().remove(usuariocarrera);
		usuariocarrera.setUsuario(null);

		return usuariocarrera;
	}

	public List<Usuariorol> getUsuariorols() {
		return this.usuariorols;
	}

	public void setUsuariorols(List<Usuariorol> usuariorols) {
		this.usuariorols = usuariorols;
	}

	public Usuariorol addUsuariorol(Usuariorol usuariorol) {
		getUsuariorols().add(usuariorol);
		usuariorol.setUsuario(this);

		return usuariorol;
	}

	public Usuariorol removeUsuariorol(Usuariorol usuariorol) {
		getUsuariorols().remove(usuariorol);
		usuariorol.setUsuario(null);

		return usuariorol;
	}

	public List<Validacion> getValidacions() {
		return this.validacions;
	}

	public void setValidacions(List<Validacion> validacions) {
		this.validacions = validacions;
	}

	public Validacion addValidacion(Validacion validacion) {
		getValidacions().add(validacion);
		validacion.setUsuario(this);

		return validacion;
	}

	public Validacion removeValidacion(Validacion validacion) {
		getValidacions().remove(validacion);
		validacion.setUsuario(null);

		return validacion;
	}

}