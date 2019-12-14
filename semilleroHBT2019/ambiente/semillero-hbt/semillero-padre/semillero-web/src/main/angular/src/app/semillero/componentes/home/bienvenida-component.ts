import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import {EjemploService} from '../../services/ejemplo.service';
import { ComicDTO } from '../../dto/comic.dto';
import { ListaDTO } from '../../dto/lista.dto';

/**
 * @description Componente bienvenida, el cual contiene la imagen de bienvenida al semillero
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'bienvenida',
  templateUrl: './bienvenida-component.html',
})
export class BienvenidaComponent implements OnInit {
  
  //declaración de variables globales
  //Url que tendra la imagen principal
  public urlImagen : string;
  //Clase DTO para los comics
  public comicDTO : ComicDTO;
  //Clase DTO que contendra la lista de Comics
  public listaDTO : ListaDTO;
  //Arreglo que contendra los objetos de tipo ListaDTO
  public dataList : Array<ListaDTO>;
  //Json con los datos de dataList
  public jsonList : string;
  //Variable encargada de la lógica de controlo para ngIf
  public mostarMensaje : boolean;
  //Variable para guardar el elemento que se borrará al presionar el botón btnErase
  public erasedElement: string;

  /**
   * @description Constructor de la clase BienvenidaComponent
   */
  constructor(private router : Router, private activatedRoute: ActivatedRoute, private ejemploService: EjemploService) {
    console.log("entro al constructor del componente bienvenida");
  }

  /**
   * ngOnit para lógica de programación, donde se asigna valores a variables 
   * que se utilizaran en Data Binding
   */
  ngOnInit(): void {
    this.urlImagen = "https://www.elempleo.com/sitios-empresariales/colombia/heinsohn-business-technology/img/elempleo-02.jpg";
    let data = this.activatedRoute.snapshot.params;
    console.log("Parametros recibidos " + data);
    //Variable para el control del *ngIf
    this.mostarMensaje = false;

    //Se inicializan los valores de las componentes que se usaran en la lista
    let dataId : Array<number> = [1,2,3,4,5];
    let dataName : Array<string> = ["batman", "superman", "Thor", "Spiderman", "Hulk"];
    let dataEditorial : Array<string> = ["DC","DC","marvel","marvel","marvel"];
    let dataTematica : Array<string> = ["accion","accion","accion","comedia","accion"];
    let dataNumeroPaginas : Array<number> = [70,40,40,20,30];
    let dataPrecio : Array<number> = [60.5,30.47,25.48,5.1,48.7];
    let dataAutores : Array<string> = ["Bob", "Jerry", "Stan", "Stan", "Stan"];
    let dataColor : Array<boolean> = [true , true , true , false , true];
    let dataDate : Array<string> = [ "2019-5-7", "2019-4-7", "2019-5-8", "2019-5-8", "2019-5-2"]
    let dataEstado : Array<string> = ["activo","activo","inactivo","activo","inactivo",]; 
    
    //se inicializa el objeto ListaDTO
    this.dataList = Array<ListaDTO>();

    for(let i = 0; i < 5; i++){
      //Se asigna valores a los atributos de la clase ListaDTO
      this.listaDTO = new ListaDTO();
      this.listaDTO.id = dataId[i]; 
      this.listaDTO.nombre = dataName[i]; 
      this.listaDTO.editorial = dataEditorial[i]; 
      this.listaDTO.tematica = dataTematica[i]; 
      this.listaDTO.numeroPaginas = dataNumeroPaginas[i]; 
      this.listaDTO.precio = dataPrecio [i]; 
      this.listaDTO.autores = dataAutores[i]; 
      this.listaDTO.aColor = dataColor[i];
      this.listaDTO.fechaVenta = new Date(dataDate[i]); 
      this.listaDTO.estado = dataEstado[i];


      /** JSON con datos extraidos de listaDTO. Se podría obviar el listaDTO y definir directamente
       *  el json, ejemplo en id:
       *  "id" : dataId[i];
       *  Sin embargo se optó por el DTO por práctica y pensando en un futuro uso del objeto, esto
       *  se modificará segun sea conveniente.
       */
      let jsonLista = {
        "id" : this.listaDTO.id,
        "nombre" : this.listaDTO.nombre,
        "editorial" : this.listaDTO.editorial,
        "tematica" : this.listaDTO.tematica,
        "numeroPaginas" : this.listaDTO.numeroPaginas,
        "precio" : this.listaDTO.precio,
        "autores" : this.listaDTO.autores,
        "aColor" : this.listaDTO.aColor,
        "fechaVenta" : this.listaDTO.fechaVenta,
        "estado" : this.listaDTO.estado
      }
      //se iran agregando los Json a la lista dataList
      this.dataList.push(jsonLista);
    }

    //Lista en formato Json de datos almacenados en listaDTO
    this.jsonList = JSON.stringify(this.dataList);
    



    
    /**
     * Parte de código ya desarrollada anteriormente en semillero:
     */
    this.ejemploService.consultarComics().subscribe(respuesta => {
      console.log(respuesta);
    });

    //Asignación de valores a ComicDTO
    this.comicDTO = new ComicDTO();    
    this.comicDTO.nombre = "BATAMAN";
    this.comicDTO.editorial = "perro";
    this.comicDTO.tematica = "no se";
    this.comicDTO.coleccion = "norma";
    this.comicDTO.numeroPaginas = 1;
    this.comicDTO.estado = "INACTIVO";
    this.comicDTO.precio = 855;
    this.comicDTO.cantidad = 1;
    this.comicDTO.tematica = "AVENTURAS"
    this.comicDTO.autores = "cindyDiego";
    this.comicDTO.color = true;

    
    this.ejemploService.crearComic(this.comicDTO).subscribe(respuesta => {
      console.log(respuesta);
    });

   
  }

  public ejecucionEventoClick( parametroEvento : any, numero : number ) : void {
    alert("Hola: " + parametroEvento + ' ' + numero);
    
  }

  
  public ejecucionEventoClickButton( numero : number ) : void {
    this.erasedElement =  JSON.stringify(this.dataList[3].nombre);
    delete this.dataList[3];
    this.mostarMensaje = true;
  }

}