package serviceInterfaz;

import java.util.List;

import dao.ClienteDao;
import dao.CuentaDao;
import dao.MovimientoDao;
import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Tipo_cuenta;
import entidades.Usuario;
import service.UsuarioService;

public interface UsuarioServiceInterfaz {


	public UsuarioDao getUsuarioDao();

	public void setUsuarioDao(UsuarioDao usuarioDao);
	
	public Usuario getUsuarioLogueado();

	public void setUsuarioLogueado(Usuario usuarioLogueado);

	public Usuario getUsuarioByNombreUsuario(String usuario);
	
    public boolean GuardarUsuario(Usuario usuarioNuevo);
	
}
