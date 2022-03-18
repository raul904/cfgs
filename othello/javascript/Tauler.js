class Tauler{
    matriuTauler;
    origenX;
    origenY;
    //true juegan negras false juegan blancas (decisió de disseny)
    booleanCanviTorn=true;
    fitxasWhiteContador;
    fitxasBlackContador;
    //si juegan las negras se guardan las negras si juegans las blancas se guardan las blancas
    arrayFitxasQueJuegan=[];
    arrayMoves=[];
    fitxasEnemigas=[];
    array1 = [];
    array2 = [];
    array3 = [];
    array4 = [];
    array5 = [];
    array6 = [];
    array7 = [];
    array8 = [];
    FitxaNegra = new Fitxa("black");
    FitxaRoja = new Fitxa("white");
    //movimientos que puedes hacer


    arrayComprovaciones=[
        [-1,0],
        [-1,1],
        [0,1],
        [1,1],
        [1,0],
        [1,-1],
        [0,-1],
        [-1,-1],

    ]
        get arrayMoves(){
        return this._arrayMoves;
     }    


    constructor(matriuTauler,arrayMoves){
        window.arrayMoves;

        matriuTauler = [ 
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0],
            [0,0,0,0,0,0,0,0] 
           ]   
           
     
    }

    inicia(matrizLlargada){
        
        // this.click();
        var Fitxa1 = new Fitxa("black");
        var Fitxa2 = new Fitxa("black");
        var Fitxa3 = new Fitxa("white");
        var Fitxa4 = new Fitxa("white");
        var Fitxa5 = new Fitxa("white");
        var Fitxa6 = new Fitxa("white");
        console.log("matriz"+matrizLlargada);
        // tabla.inicia(partida.tamanyoTablero);
        switch(parseInt(partida.tamanyoTablero)){
           
            case 16:
                console.log(partida.tamanyoTablero);
                this.matriuTauler = [ 
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,Fitxa3,Fitxa1,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,Fitxa2,Fitxa4,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0] 
                   ]   
                
                   $( '#r7c7' ).append( "<img src=img/fichaNegraReina.png>" );
                   $( '#r8c8' ).append( "<img src=img/fichaNegraReina.png>" );

                   $( '#r7c8' ).append( "<img src=img/fichaRojaReina.png>" );
                   $( '#r8c7' ).append( "<img src=img/fichaRojaReina.png>" );

                   this.movimientosDisponibles();

                break;
            case 10:
                console.log(partida.tamanyoTablero);
                this.matriuTauler = [ 
                    [0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,Fitxa3,Fitxa1,0,0,0,0],
                    [0,0,0,0,Fitxa2,Fitxa4,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0,0,0] 
                   ]   
                   $( '#r4c4' ).append( "<img src=img/fichaNegraReina.png>" );
                   $( '#r5c5' ).append( "<img src=img/fichaNegraReina.png>" );

                   $( '#r4c5' ).append( "<img src=img/fichaRojaReina.png>" );
                   $( '#r5c4' ).append( "<img src=img/fichaRojaReina.png>" );

                   this.movimientosDisponibles()
              
                break;
            case 8:
               
                //como empieza la partida
                this.matriuTauler = [ 
                    [0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0],
                    [0,0,0,Fitxa3,Fitxa1,0,0,0],
                    [0,0,0,Fitxa2,Fitxa4,0,0,0],
                    [0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0],
                    [0,0,0,0,0,0,0,0] 
                   ]   

                   $( '#r3c3' ).append( "<img src=img/fichaRojaReina.png>");
                   $( '#r4c4' ).append( "<img src=img/fichaRojaReina.png>" );

                   $( '#r3c4' ).append( "<img src=img/fichaNegraReina.png>" );
                   $( '#r4c3' ).append( "<img src=img/fichaNegraReina.png>" );
               
                   
                   this.movimientosDisponibles();
                   
              
                break;

        }

   
    }


    //me guardo las fitxas que juegan
    movimientosDisponibles(){
        partida.marcadores();

        // let arrayFitxasQueJuegan= [];
   
        console.log(partida.tamanyoTablero);
        for(let i=0;i<8;i++){
        
            for(let j=0; j<8;j++){

                if(this.booleanCanviTorn){
                    if( this.matriuTauler[i][j].stringColor=="black"){
                        this.arrayFitxasQueJuegan.push( i+" "+j);
                       
                    }
                }

                if(!this.booleanCanviTorn){
                    if( this.matriuTauler[i][j].stringColor=="white"){
                        this.arrayFitxasQueJuegan.push( i+" "+j);
                    
                    }
                }
                    

            }
        }
        //array split
        let splitear = [];
        for(let s=0;s<this.arrayFitxasQueJuegan.length;s++){
            
            splitear = this.arrayFitxasQueJuegan[s].split(" ");
            tabla.origenX = splitear[0];
            tabla.origenY = splitear[1];
     
            
             tabla.actualiza();
        }
        

    }

    
    
    termina(){
        var con=document.getElementById("fitxaJug1");
        var con2=document.getElementById("fitxaJug2");
        //INSERTA CUANTAS FICHAS QUEDAN A CADA JUGADOR    
        con.innerHTML  = this.fitxasBlackContador;
        con2.innerHTML = this.fitxasWhiteContador; 
        if(this.fitxasWhiteContador==0||this.fitxasBlackContador==0){
       
            partida.terminaJuego();
            this.fitxasBlackContador=12;
            this.fitxasWhiteContador=12;
        }
    }

    actualiza(){
       
        ///MOVE NEGRAS////////      
    ///move negras hacia abajo de casilla en casilla
        if(this.booleanCanviTorn){
            if((this.matriuTauler[this.origenX][this.origenY].stringColor=="black")&&(this.booleanCanviTorn)){  
            //cambiar nombre a mueve fitxa
            this.moveFitxaNegra();
            this.termina();
            
                }
            }
        if(!this.booleanCanviTorn){
                if((this.matriuTauler[this.origenX][this.origenY].stringColor=="white")&&(!this.booleanCanviTorn)){  
                //cambiar nombre a mueve fitxa
                this.moveFitxaNegra();
                this.termina();
                
                    }
                }

     }

    seleciona(r,c){
        return this.matriuTauler[r][c];
    }
  

    ////////////////MOVE NEGRAS/////////////////////////////////////
    moveFitxaNegra(){
   

        for(let i=0; i<8;i++){
            
            if(this.booleanCanviTorn){
                if(this.matriuTauler[this.origenX-this.arrayComprovaciones[i][0]][this.origenY-this.arrayComprovaciones[i][1]].stringColor=="white"){
                    
                    //pasamos el origen i la iteracion del array que a encontrado la ficha
                    this.arrayMoves = this.encuentraCasillaVacia(parseInt(this.origenX-this.arrayComprovaciones[i][0]),parseInt(this.origenY-this.arrayComprovaciones[i][1]),parseInt(this.arrayComprovaciones[i][0]),parseInt(this.arrayComprovaciones[i][1]));
            
                }
            }
            if(!this.booleanCanviTorn){
                if(this.matriuTauler[this.origenX-this.arrayComprovaciones[i][0]][this.origenY-this.arrayComprovaciones[i][1]].stringColor=="black"){
                    
                    //pasamos el origen i la iteracion del array que a encontrado la ficha
                    this.arrayMoves = this.encuentraCasillaVacia(parseInt(this.origenX-this.arrayComprovaciones[i][0]),parseInt(this.origenY-this.arrayComprovaciones[i][1]),parseInt(this.arrayComprovaciones[i][0]),parseInt(this.arrayComprovaciones[i][1]));
            
                }
            }
                
        }
        
    }

       


    encuentraCasillaVacia(oriX,oriY,posy,posx){
        let espacioEncontrado= false;
    
        while(!espacioEncontrado){       
            switch(posx+" "+posy){
                case "0 1":
                    this.array1.push(oriX+" "+oriY);
                    break;
                case "-1 0":
                    this.array2.push(oriX+" "+oriY);
                    break;
                case "-1 1":
                    this.array3.push(oriX+" "+oriY);
                    break;
                case "1 1":
                    this.array4.push(oriX+" "+oriY);
                    break;    
                case "1 0":
                    this.array5.push(oriX+" "+oriY);
                    break;  
                case "1 -1":
                    this.array6.push(oriX+" "+oriY);
                    break;  
                case "0 -1":
                    this.array7.push(oriX+" "+oriY);
                    break;  
                case "-1 -1":
                    this.array8.push(oriX+" "+oriY);
                    break; 
            
            }

            oriX = oriX - posy;
            oriY = oriY -posx;
            // this.fitxasEnemigas.push(oriX+" "+oriY);
            if(this.matriuTauler[oriX][oriY]==0){
              

                
                switch(posx+" "+posy){
                    case "0 1":
                        this.array1.push(oriX+" "+oriY);                  
                        break;
                    case "-1 0":
                        this.array2.push(oriX+" "+oriY);
                        break;
                    case "-1 1":
                        this.array3.push(oriX+" "+oriY);
                        break;
                    case "1 1":
                        this.array4.push(oriX+" "+oriY);
                        break;
                    case "1 0":
                        this.array5.push(oriX+" "+oriY);
                        break;  
                    case "1 -1":
                        this.array6.push(oriX+" "+oriY);
                        break; 
                    case "0 -1":
                        this.array7.push(oriX+" "+oriY);
                        break;
                    case "-1 -1":
                        this.array8.push(oriX+" "+oriY);
                        break;
                }

                this.arrayMoves.push(oriX+" "+oriY);
            
                $("#r"+oriX+"c"+oriY).css("background-color","red");
        
                
                espacioEncontrado=true;
            }
        }

        return this.arrayMoves;

    }

    gira(r,c){
    
    
        //camino "0 1":
        if(this.array1.includes(r+" "+c)){
            console.log(this.array1);
            this.array1.forEach(element => {
                let splitear = element.split(" ");
              

                  
                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                      }
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

       
      
        }

        else if(this.array2.includes(r+" "+c)){
            console.log(this.array2);
            this.array2.forEach(element => {
                
                let splitear = element.split(" ");
                    console.log(splitear[0],splitear[1]);

                    
                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                      }
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

       
      
        }

        else if(this.array3.includes(r+" "+c)){
            console.log(this.array3);
            this.array3.forEach(element => {
                let splitear = element.split(" ");
                    console.log(splitear[0],splitear[1]);

                    
                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                      }
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

        }

        else if(this.array4.includes(r+" "+c)){
            console.log(this.array4);
            this.array4.forEach(element => {
                let splitear = element.split(" ");
                    console.log(splitear[0],splitear[1]);

                  
                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                      }
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

        }

        else if(this.array5.includes(r+" "+c)){
            console.log(this.array5);
            this.array5.forEach(element => {
                let splitear = element.split(" ");
                    console.log(splitear[0],splitear[1]);

                 
                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                      }
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

        }

        else if(this.array6.includes(r+" "+c)){
            console.log(this.array6);
            this.array6.forEach(element => {
                let splitear = element.split(" ");
                    console.log(splitear[0],splitear[1]);

                    
                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                      }
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

        }

        else if(this.array7.includes(r+" "+c)){
            console.log(this.array);
            this.array7.forEach(element => {
                let splitear = element.split(" ");
                    console.log(splitear[0],splitear[1]);

                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                      }
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

        }

        else if(this.array8.includes(r+" "+c)){

            this.array8.forEach(element => {
                let splitear = element.split(" ");
                    console.log(splitear[0],splitear[1]);

                   
                    
                    let divImage = document.getElementById("r"+splitear[0]+"c"+splitear[1]);
             
                    // divImage.classList.css("background-color","blue");
                    if(divImage.firstChild){
                    divImage.firstChild.replaceWith();
                 
                    // console.log(divImage.firstChild);
                   
                      }
                    
                      
                      if(this.booleanCanviTorn){
                        this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaNegra;
                        $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaNegraReina.png>" );
                            }else{
                                this.matriuTauler[splitear[0]][splitear[1]]=this.FitxaRoja;
                                $( '#r'+splitear[0]+'c'+splitear[1] ).append( "<img src=img/fichaRojaReina.png>" );
                            }

         
            });

        }
        //quitamos las casillas rojas
        let esborraVermell =  document.getElementsByClassName("columna");
        for (let index = 0; index < esborraVermell.length; index++) {
                $(esborraVermell[index]).css("background-color","#35682d");  
        }

        //ponemos todos los arrays a 0 
          this.array1 = [];
          this.array2 = [];
          this.array3 = [];
          this.array4 = [];
          this.array5 = [];
          this.array6 = [];
          this.array7 = [];
          this.array8 = [];

          this.arrayMoves=[];
          this.fitxasEnemigas=[];
        if(this.booleanCanviTorn){
            this.fitxasBlackContador= this.arrayFitxasQueJuegan.length + 2 ;
        }
        if(!this.booleanCanviTorn){
            this.fitxasWhiteContador= this.arrayFitxasQueJuegan.length + 2 ;
        }
     
          this.arrayFitxasQueJuegan=[];
        //   booleanValue = !booleanValue
        //   this.booleanCanviTorn = false;
        this.booleanCanviTorn = !this.booleanCanviTorn;
          console.log(this.booleanCanviTorn);
         this.movimientosDisponibles();
      
   
    
    }
    

    
    
  


    
      
}




    
