package com.api.apis.Controlador;

import com.api.apis.Connection.ConnectionSQL;
import com.api.apis.Connection.Utils;
import com.api.apis.Modelo.Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorDao {
    
    PreparedStatement sentencia = null;
    ResultSet rs = null;
    Utils utils = new Utils();
    
    public Colaborador loginUsuario(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        
        // Crear un objeto ConexionMySQL para conectarnos a la base de datos
        ConnectionSQL con = new ConnectionSQL();

        // Obtener la conexión a la base de datos
        Connection _conexion = con.conector();
        
        // Definir la consulta SQL para buscar el colaborador por su rut y contraseña
        String sqlSelect = "SELECT "
                + "id, "
                + "rut, "
                + "nombres, "
                + "apellidos,"
                + "token_sesion, "
                + "path_colaborador, "
                + "perfil_id "
                + "FROM "
                + "gp_colaborador "
                + "WHERE "
                + "rut = ? AND "
                + "password = MD5(?)";
        
        // Preparar la sentencia SQL para su ejecución
        sentencia = _conexion.prepareStatement(sqlSelect);
        sentencia.setString(1, colaborador.getRut());
        sentencia.setString(2, colaborador.getPassword());
        
        // Ejecutar la consulta SQL y obtener el resultado
        rs = sentencia.executeQuery();
        
        // Crear un objeto Colaborador para almacenar los datos del colaborador que ha iniciado sesión
        Colaborador col = new Colaborador();
        
        // Si se encuentra un registro en la consulta, llenar los datos del colaborador y actualizar su token de sesión
        if (rs.next()) {
            col.setId(rs.getInt("id"));
            col.setRut(rs.getString("rut"));
            col.setNombres(rs.getString("nombres"));
            col.setApellidos(rs.getString("apellidos"));
            col.setPathColaborador(rs.getString("path_colaborador"));
            col.setPerfil(rs.getInt("perfil_id"));
            //colaborador.setTokenSesion(rs.getString("token_sesion"));
            
            String tokenUsuario = updateTokenColaborador(rs.getInt("id"));
            
            col.setTokenSesion(tokenUsuario);
            // Devolver el objeto Colaborador con los datos del colaborador que ha iniciado sesión
            return col;
            
        } else {
            // Si no se encuentra ningún registro, lanzar una excepción indicando que no se encontró el colaborador
            throw new SQLException("No se encontro colaborador");
        }
        
        
    }
    
    public String updateTokenColaborador(int id) throws SQLException, ClassNotFoundException{
        // Crear un objeto ConexionMySQL para conectarnos a la base de datos
        ConnectionSQL con = new ConnectionSQL();

        // Obtener la conexión a la base de datos
        Connection _conexion = con.conector();
        
        String token = utils.generaToken(); // Generar el token aleatorio
        
        String sqlUpdate = "UPDATE gp_colaborador SET token_sesion = ? WHERE id = ?;";
        sentencia = _conexion.prepareStatement(sqlUpdate);
        sentencia.setString(1, token);
        sentencia.setInt(2, id);
        sentencia.executeUpdate();
        return token;
    }
    
    public List<Colaborador> listarColaboradores() throws SQLException, ClassNotFoundException{
        // Crear un objeto ConexionMySQL para conectarnos a la base de datos
        ConnectionSQL con = new ConnectionSQL();

        // Obtener la conexión a la base de datos
        Connection _conexion = con.conector();
        
        // Crear la sentencia SQL para insertar un huerto
        String sqlSelect = """
                           SELECT 
                           \tcolaborador.id AS id
                               , colaborador.rut AS rut
                               , colaborador.nombres AS nombres
                               , colaborador.apellidos AS apellidos
                               , colaborador.estado_civil AS estado_civil
                               , colaborador.sexo AS sexo
                               , colaborador.perfil_id AS perfil_id
                           FROM gp_colaborador colaborador
                           INNER JOIN gp_cargo cargo ON cargo.id = colaborador.cargo_id;""";
       
        try (PreparedStatement psSelect = _conexion.prepareStatement(sqlSelect)) {

            // Ejecutar la sentencia SQL
            ResultSet rsSelect = psSelect.executeQuery();

            // Recorrer los resultados y mostrarlos por consola
            List<Colaborador> listaColaborador = new ArrayList<>();
            while (rsSelect.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setId(rsSelect.getInt("id"));
                colaborador.setRut(rsSelect.getString("rut"));
                colaborador.setNombres(rsSelect.getString("nombres"));
                colaborador.setApellidos(rsSelect.getString("apellidos"));
                colaborador.setEstadoCivil(rsSelect.getString("estado_civil"));
                colaborador.setSexo(rsSelect.getString("sexo"));
                
                colaborador.setPerfil(rsSelect.getInt("perfil_id"));

                listaColaborador.add(colaborador);
            }
            return listaColaborador;
        }
    }
}
