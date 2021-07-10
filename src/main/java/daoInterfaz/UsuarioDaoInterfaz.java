package daoInterfaz;
 
import entidades.Usuario;

public interface UsuarioDaoInterfaz {
	
	public Usuario getUsuarioByNombreUsuario(String usuario);

	public Usuario traerUsuario(int id);
	 
    public void guardarNuevoUsuario (Usuario usuarioNuevo);

}
