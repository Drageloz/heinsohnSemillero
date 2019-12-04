import { Component, OnInit } from '@angular/core';

/**
 * @description La clase MostrarNombreComponent permite mostrar Nombre y ciudad de residencia de Autor
 * @author Andres Dario Suarez Guarnizo <andres.dario1906@gmail.com>
 */
@Component({
    selector: 'mostrar-nombre',
    templateUrl: './mostrar-nombre-component.html',
    styleUrls: ['./mostrar-nombre-component.css']
})

export class MostrarNombreComponent implements OnInit{
    
    public nombre : string;
    public ciudad : string;
    public datosConcatenados : string;

    /**
     * @description Este es el constructor del componente MostrarNombreComponent
     * @author Andres Dario Suarez Guarnizo <andres.dario1906@gmail.com>
     */
    constructor(){}
    
    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Andres Dario Suarez Guarnizo <andres.dario1906@gmail.com>
     */    
    ngOnInit(): void {
        this.nombre = 'Andres Dario Suarez Guarnizo';
        this.ciudad = 'Montería, Colombia';
        this.datosConcatenados = this.nombre + " - " + this.ciudad;
    }

    
    
    

}