class Partida{
    booleanCanviTorn=true;
    iniciaPartida=true;
    inputValueJug1="";
    inputValueJug2="";
    name1;
    name2;
    contadorWinsJug1=0;
    contadorWinsJug2=0;
    tamanyoTablero;

    

    constructor(){
        this._booleanCanviTorn = true;
        this._quedanMovimientos=true;
     
  
        document.getElementById('play').addEventListener("click", () => {this.saveNames( )});
    }

    
 
     saveNames(){

    
   
       
         this.inputValueJug1 = document.getElementById("jug1").value; 
         this.inputValueJug2 = document.getElementById("jug2").value; 
        //inputValueJug1 = "raul";
        //inputValueJug2 = "rulas";
    
        if(this.inputValueJug1 !="" && this.inputValueJug2 != ""){
       
       
         let name1=document.getElementById("jugador1");
         let name2=document.getElementById("jugador2");
        //INSERTA NOMBRES DE LOS JUGADORES    
        name1.innerHTML  = this.inputValueJug1; 
        name2.innerHTML = this.inputValueJug2;
    

        
    
        
        var rellena = new Rellena();
  

    
        // rellena.omplehtml(parseInt(this.tamanyoTablero));

        console.log(this.tamanyoTablero);
        
        rellena.omplehtml();

    

        //ESCONDE MODAL
        $('#exampleModal').modal('hide');
        
        //LLENA TABLERO
        // tabla.ompleTauler();
        

        //boton reinicia
        document.getElementById('reinicia').addEventListener("click", () => {this.reinicia()});

        

      
       // tabla.actualiza();



        
    }else{
        //torna a mostra el modal ja que el noms estan buits
        $( document ).ready(function() {
            $('#exampleModal').modal('show');
        });
     

    }

    }
    //recarga la pagina
    reinicia(){
        location.reload();
    }

    terminaJuego(){
 
    $( document ).ready(function() {
        $('#exampleModal2').modal('show');
    });


    let guanyador = document.getElementById("guanyador");
    let jug1Puntuacio = document.getElementById("jug1Puntuacio");
    let jug2Puntuacio = document.getElementById("jug2Puntuacio");
    let jug1NombrePuntuacion = document.getElementById("player1");
    let jug2NombrePuntuacion = document.getElementById("player2");
    
    // <p id="guanyador"></p>
    // <p id="jug1Puntuacio"></p>
    // <p id="jug2Puntuacio"></p>

    if(tabla.fitxasBlackContador==0){
      guanyador.innerHTML = this.inputValueJug2;
      this.contadorWinsJug2++;
      console.log(this.contadorWinsJug1,this.contadorWinsJug2)

    }
    if(tabla.fitxasWhiteContador==0){
        guanyador.innerHTML = this.inputValueJug1;
        this.contadorWinsJug1++;
        console.log(this.contadorWinsJug1,this.contadorWinsJug2)
        }
    
        jug1Puntuacio.innerHTML=this.contadorWinsJug1;
        jug2Puntuacio.innerHTML=this.contadorWinsJug2;
        console.log(this.contadorWinsJug1,this.contadorWinsJug2)
        jug1NombrePuntuacion.innerHTML=this.inputValueJug1;
        jug2NombrePuntuacion.innerHTML=this.inputValueJug2;

        tabla.ompleTauler();
        //Guardem totes les caselles en un array
        let arrayColumns = document.getElementsByClassName("columnaNegra");
        //recorrem les caselles
        for(let i=0;i<arrayColumns.length;i++){
            //si te fills
            if(arrayColumns[i].hasChildNodes){
                //si el primer fill no es null entra i remplaça deixant-ho buit
                if(arrayColumns[i].firstChild!=null){
                  arrayColumns[i].firstChild.replaceWith();
            
                }       
        }
    
        }

        rellena.omplehtml();  
        document.getElementById('juga').addEventListener("click", () => {this.amagaModal()});

    }


    amagaModal(){
        $( document ).ready(function() {
            $('#exampleModal2').modal('hide');
        });
        tabla.fitxasBlackContador=1;
        tabla.fitxasWhiteContador=1;
        this.booleanCanviTorn=true;
        tabla.actualiza();

        
    }

    marcadores(){
        
        let jug1NombrePuntuacion = document.getElementById("player1");
        let jug2NombrePuntuacion = document.getElementById("player2");
        
        jug1NombrePuntuacion.innerHTML= tabla.fitxasBlackContador;
        jug2NombrePuntuacion.innerHTML= tabla.fitxasWhiteContador;
       
    }

    get booleanCanviTorn(){
        return this._booleanCanviTorn;
    }

    set booleanCanviTorn(booleanCanviTorn){
        this._booleanCanviTorn = booleanCanviTorn;
    }

  

}

    
