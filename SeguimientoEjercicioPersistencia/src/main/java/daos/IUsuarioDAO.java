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
    Usuario crear(Usuario usuario);
    Usuario obtener(Usuario usuario);
}