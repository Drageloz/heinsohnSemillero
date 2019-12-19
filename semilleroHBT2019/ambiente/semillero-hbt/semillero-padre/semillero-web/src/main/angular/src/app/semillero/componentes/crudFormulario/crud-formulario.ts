
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'crud-formulario',
    templateUrl: './crud-formulario.html',
})

export class GestionarFormularioCRUDComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarFormularioCRUDForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
        private router : Router,  private activatedRoute: ActivatedRoute) {
        this.gestionarFormularioCRUDForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : [null],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit de crud-formulario");
        //Se asignan los valores a cada input del formulario, y se desabilita su edición.
        let data = this.activatedRoute.snapshot.params;
        this.gestionarFormularioCRUDForm.controls.nombre.setValue(data.nombre);
        this.gestionarFormularioCRUDForm.controls.editorial.setValue(data.editorial);
        this.gestionarFormularioCRUDForm.controls.tematica.setValue(data.tematica);
        this.gestionarFormularioCRUDForm.controls.coleccion.setValue(data.coleccion);
        this.gestionarFormularioCRUDForm.controls.numeroPaginas.setValue(data.numeroPaginas);
        this.gestionarFormularioCRUDForm.controls.precio.setValue(data.precio);
        this.gestionarFormularioCRUDForm.controls.autores.setValue(data.autores);
        this.gestionarFormularioCRUDForm.controls.color.setValue(data.color);
        this.gestionarFormularioCRUDForm.controls.nombre.disable();
        this.gestionarFormularioCRUDForm.controls.editorial.disable();
        this.gestionarFormularioCRUDForm.controls.tematica.disable();
        this.gestionarFormularioCRUDForm.controls.coleccion.disable();
        this.gestionarFormularioCRUDForm.controls.numeroPaginas.disable();
        this.gestionarFormularioCRUDForm.controls.precio.disable();
        this.gestionarFormularioCRUDForm.controls.autores.disable();
        this.gestionarFormularioCRUDForm.controls.color.disable();

    }
    

    
}