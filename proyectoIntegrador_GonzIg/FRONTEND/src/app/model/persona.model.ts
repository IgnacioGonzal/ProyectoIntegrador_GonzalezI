export class Persona {
    id?: number;
     nombre: String;
   
    apellido: String;
    img: String;

    constructor(  nombre: string,  apellido: string,  img: string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
}
