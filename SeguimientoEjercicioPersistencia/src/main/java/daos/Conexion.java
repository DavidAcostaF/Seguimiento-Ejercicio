/*
 * Conexion.java
 */
package com.mycompany.agenciafiscaldaos;

import daos.IConexion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * La clase Conexion implementa la interfaz {@link IConexion} y proporciona
 * métodos para obtener una conexión a la base de datos utilizando JPA (Java
 * Persistence API).
 *
 * La conexión se establece utilizando el nombre de unidad de persistencia
 * "AgenciaFiscalPU", que está configurada en el archivo persistence.xml.
 *
 * Esta clase es responsable de crear y devolver una instancia de EntityManager
 * que se utiliza para realizar operaciones en la base de datos.
 *
 * La clase Conexion es parte del conjunto de clases DAO (Data Access Object)
 * utilizadas para interactuar con la capa de persistencia de la aplicación.
 *
 */
public class Conexion implements IConexion {

    /**
     * Obtiene una conexión a la base de datos utilizando JPA (Java Persistence
     * API).
     *
     * @return Una instancia de EntityManager que representa la conexión a la
     * base de datos.
     */
    @Override
    public EntityManager obtenerConexion() {
        //Obtenemos acceso a la fábrica de entity managers
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("SeguimientoEjercicioPU");
        // Solicitamos una entity manager (acceso a la BD)
        EntityManager entityManager = emFactory.createEntityManager();

        return entityManager;
    }



}
