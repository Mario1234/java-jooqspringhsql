/*
 * This file is generated by jOOQ.
 */
package comun.jooq.tables.records;


import comun.jooq.tables.Usuario;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsuarioRecord extends UpdatableRecordImpl<UsuarioRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -909827663;

    /**
     * Setter for <code>PUBLIC.USUARIO.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.USUARIO.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>PUBLIC.USUARIO.NOMBRE</code>.
     */
    public void setNombre(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.USUARIO.NOMBRE</code>.
     */
    public String getNombre() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.USUARIO.APELLIDO</code>.
     */
    public void setApellido(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.USUARIO.APELLIDO</code>.
     */
    public String getApellido() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    
    public Field<Integer> field1() {
        return Usuario.USUARIO.ID;
    }

  
    public Field<String> field2() {
        return Usuario.USUARIO.NOMBRE;
    }


    public Field<String> field3() {
        return Usuario.USUARIO.APELLIDO;
    }

    
    public Integer component1() {
        return getId();
    }

  
    public String component2() {
        return getNombre();
    }


    public String component3() {
        return getApellido();
    }

 
    public Integer value1() {
        return getId();
    }


    public String value2() {
        return getNombre();
    }


    public String value3() {
        return getApellido();
    }


    public UsuarioRecord value1(Integer value) {
        setId(value);
        return this;
    }


    public UsuarioRecord value2(String value) {
        setNombre(value);
        return this;
    }


    public UsuarioRecord value3(String value) {
        setApellido(value);
        return this;
    }

    
    public UsuarioRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsuarioRecord
     */
    public UsuarioRecord() {
        super(Usuario.USUARIO);
    }

    /**
     * Create a detached, initialised UsuarioRecord
     */
    public UsuarioRecord(Integer id, String nombre, String apellido) {
        super(Usuario.USUARIO);

        set(0, id);
        set(1, nombre);
        set(2, apellido);
    }
}
