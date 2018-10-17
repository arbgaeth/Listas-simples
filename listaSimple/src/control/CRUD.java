/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import entity.persona;
/**
 *
 * @author macbookair
 */
public class CRUD {
    persona cab;//global
    //CREATE
    private persona Create(){
        // return new persona();
        persona nn = new persona();//crea un objeto.
        return nn;//return la direccion de memoria RAM
    }
    private persona setInfo(persona nn,int id, String nombre, String apellido, String direccion, String telefono, float estatura, int edad){
        nn.setId(id);
        nn.setNombre(nombre);
        nn.setApellido(apellido);
        nn.setDireccion(direccion);
        nn.setTelefono(telefono);
        nn.setEstatura(estatura);
        nn.setEdad(edad);
        return nn;
    }
    private persona insert(persona nn){
        if(this.cab != null){//si la lista tiene nodos
            persona p = this.cab;
            //recorrido de la lista
            while(p.getSig()!= null){
                p = p.getSig();
            }
            p.setSig(nn);
        }else{//si la lista está vacía 
            this.cab = nn;
        }
        return this.cab;
    }
    private persona insertL(persona nn){
        if(this.cab != null){//si hay nodos en la lista
            nn.setSig(this.cab);
            this.cab = nn;
        }else{//si la lista está vacía
            this.cab = nn;
        }
        return this.cab;
    }
    public boolean insert(int id, String nombre, String apellido, String direccion, String telefono, float estatura, int edad){
        persona nn =  this.Create();
        nn = this.setInfo(nn, id, nombre, apellido, direccion, telefono, estatura, edad);
        nn = this.insert(nn);
        if(nn != null){
            return true;
        }else{
            return false;
        }
    }
    public boolean insertL(int id, String nombre, String apellido, String direccion, String telefono, float estatura, int edad){
        if(this.insertL(this.setInfo(this.Create(), id, nombre, apellido, direccion, telefono, estatura, edad))!= null){
            return true;
        }else{
            return false;
        }
    }
    //READ
    public String showAll(){
        String resp = "";
        if(this.cab != null){
            persona p = this.cab;
            while(p!=null){
                System.out.println(p.getId()+"-"+p.getNombre()+"-"+p.getApellido()+"-"+p.getDireccion()+"-"+p.getTelefono()+"-"+p.getEstatura()+"-"+p.getEdad());
                resp = resp+p.getId()+"-"+p.getNombre()+"-"+p.getApellido()+"-"+p.getDireccion()+"-"+p.getTelefono()+"-"+p.getEstatura()+"-"+p.getEdad()+"\n";
                p = p.getSig();
            }
            return resp;
        }else{
            return "No hay datos";
        }
    }
    private persona selectById(int id){
        /*if(this.cab != null){
            persona p =  this.cab;
            while(p.getSig() != null && p.getId()!= id){
                p = p.getSig();
            }
            if(p.getId() == id){
                return p;
            }else{
                return null;
            }
        }else{
            return null;
        }*/
        //////// 
        if(this.cab != null){
            persona p =  this.cab;
            while(p != null){
                if(p.getId() == id){
                    return p;
                }
                p = p.getSig();
            }
            return null;
        }else{
            return null;
        }
    }
    public String selectPersonaById(int id){
        if(this.selectById(id)!= null){
           persona p =  this.selectById(id);
           return p.getId()+"-"+p.getNombre()+"-"+p.getApellido()+"-"+p.getDireccion()+"-"+p.getTelefono()+"-"+p.getEstatura()+"-"+p.getEdad();
        }else{
           return null;
        }
    }
    //UPDATE
    public boolean update(int id, String nombre, String apellido, String direccion, String telefono, float estatura, int edad){
        persona p = this.selectById(id);
        if(p != null){
            this.setInfo(p, id, nombre, apellido, direccion, telefono, estatura, edad);
            return true;
        }else{
            return false;
        }
    }
    //DELETE
    public boolean delete(int id){
        persona q = this.selectById(id);
        persona p;
        if(q != null){//evalua si el nodo a ser eliminado existe en la lista
            if(q != this.cab){//El nodo que se eliminará es un nodo interno
                p = this.cab;
                while(p.getSig() != q){// recorrido hasta el nodo anterior a Q
                    q = q.getSig();
                }
                p.setSig(q.getSig()); //Salto del conejo
                return true;
            }else{//El nodo que se va a eliminar es el de la cabeza
                if(q.getSig() != null){//hay más nodos en la lista
                    this.cab = q.getSig();//reposiciona la cabeza
                    return true;
                }else{//hay un solo nodo en la lista
                    this.cab = null;//lista vacía
                    return true;
                }
            }
        }else{//no se encontró el nodo requerido en la lista
            return false;
        }
    }
}   