/**
 * @description Clase ListaDTO que contiene la informacion de una lista
 * 
 * @author Andres Suarez <drageloz@gmail.com>
 */
export class ListaDTO {

    /**
     * Identificador de la lista 
     */
    public id : number; 
    
    /**
     * nombre 
     */
    public nombre : string;
    
    public editorial : string; 
    
    public tematica : string; 
    
    public numeroPaginas : number; 
    
    public precio : number; 
    
    public autores : string; 
    
    public aColor : boolean;
    
    public fechaVenta : Date; 
    
    public estado : string;

}