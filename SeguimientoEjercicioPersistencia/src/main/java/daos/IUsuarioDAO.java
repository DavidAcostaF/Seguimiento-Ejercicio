/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import dominio.Usuario;

/**
 *
 * @author af_da
 */
public interface IUsuarioDAO {
    public Usuario crear(Usuario usuario);
    public Usuario obtener(Usuario usuario);
    public Usuario obtenerNombre(String nombreUsuario);
    public void borrar(Usuario usuario);
}
