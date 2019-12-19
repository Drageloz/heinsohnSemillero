
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
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

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
     * Atributo para control del id del comic seleccionado, para poder editarlo.
     */
    public idComicSelected : number;
    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /** 
     * Atributo que indica cuando el boton del formulario, debe crear o actualizar la informacion.
    */
    public actualizarBandera : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author andres Dario Suarez <drageloz@gmail.com>
     */
    constructor(private fb : FormBuilder,
        private router : Router, private activatedRoute: ActivatedRoute) {
        this.gestionarComicForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : ["AVENTURAS"],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [true]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author andres Dario Suarez <drageloz@gmail.com>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     * @author andres Dario Suarez <drageloz@gmail.com>
     */
    public crearActualizarComic() : void {
        this.submitted = true;
        //constata si hay errores y de ser el caso se regresa y muestra que datos fallaron
        if(this.gestionarComicForm.invalid) {
            return;
        }

        //Constata si se debe actualizar o crear un comic
        if(this.actualizarBandera){
            this.listaComics[this.idComicSelected].nombre = this.gestionarComicForm.controls.nombre.value
            this.listaComics[this.idComicSelected].editorial = this.gestionarComicForm.controls.editorial.value;
            this.listaComics[this.idComicSelected].tematica = this.gestionarComicForm.controls.tematica.value;
            this.listaComics[this.idComicSelected].coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.listaComics[this.idComicSelected].numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.listaComics[this.idComicSelected].precio = this.gestionarComicForm.controls.precio.value;
            this.listaComics[this.idComicSelected].autores = this.gestionarComicForm.controls.autores.value;
            this.listaComics[this.idComicSelected].color = this.gestionarComicForm.controls.color.value;
            this.limpiarFormulario();
        }
        else{
            this.idComic++;
            this.comic = new ComicDTO();
            this.comic.id = this.idComic + "";
            this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
            this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
            this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
            this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
            this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            this.comic.precio = this.gestionarComicForm.controls.precio.value;
            this.comic.autores = this.gestionarComicForm.controls.autores.value;
            this.comic.color = this.gestionarComicForm.controls.color.value;
            
            this.listaComics.push(this.comic);
            this.limpiarFormulario();
        }
    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.router.navigate(['crud-formulario',comic]);
    }


    /**
     * Metodo que permite editar un comic de la tabla y sus detalles habilitando el formulario
     * @param comic que se desea editar
     */
    public editarComic(comic : any) : void {
        this.actualizarBandera = true;
        this.idComicSelected = comic.id;
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
    }

    /**
     * Metodo que permite eliminar un comic de la tabla y sus detalles
     * @param posicion en la lista del comic seleccionado
     */
    public eliminarComic(position : any) : void {
        this.listaComics.splice(position-1,1);
    }

    /**
     * Metodo que permite limpiar los datos en el formulario llevandolos a su valor estandar y estableciendo sus banderas en falso
     */
    private limpiarFormulario() : void {
        this.submitted = false;
        this.actualizarBandera = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue("AVENTURAS");
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(true);
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }
}