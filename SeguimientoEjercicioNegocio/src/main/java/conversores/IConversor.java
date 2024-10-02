/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conversores;

import dtos.UsuarioDTO;

/**
 *
 * @author af_da
 * @param <ENTIDAD>
 * @param <DTO>
 */
public interface IConversor<ENTIDAD,DTO> {
    public DTO EntidadADTO(ENTIDAD entidad);
    public ENTIDAD DTOAEntidad(DTO dto);
}
