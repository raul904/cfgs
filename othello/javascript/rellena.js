class Rellena{ 
    
    // console.log(array);
    constructor(){}
    //omple el html amb id i dona un nova clase columnaNegre que serà les caselles on es jugarà

    omplehtml(){
        console.log(partida.tamanyoTablero);
        let parametroTablero;
        if(partida.tamanyoTablero==16){
            for(let i =0; i<partida.tamanyoTablero;i++){
            $( ".tablero" ).append( "<div class='fila'></div>" );
            $(".fila").css("height","6.25%");

            }

            $( ".fila" ).each(function( index ) {
                $( ".fila" ).append( "<div class='columna'></div>" );
            
            });

            for(let y=0; y<16;y++){

                var children = $( ".fila" ).eq( y ).children();
                
                    for(let m=0;m<children.length;m++){
                        children[m].setAttribute("id","r"+y +"c"+m);
                
                    }
                }
          
                // tabla.inicia(16);

                // tabla.inicia(partida.tamanyoTablero);
                tabla.inicia();
        }

        if(partida.tamanyoTablero==10){
            for(let i =0; i<partida.tamanyoTablero;i++){
            $( ".tablero" ).append( "<div class='fila'></div>" );
            $(".fila").css("height","10%");
            }

            $( ".fila" ).each(function( index ) {
                $( ".fila" ).append( "<div class='columna'></div>" );
            });


            for(let y=0; y<10;y++){

                var children = $( ".fila" ).eq( y ).children();
                
                    for(let m=0;m<children.length;m++){
                        children[m].setAttribute("id","r"+y +"c"+m);
                
                    }
                }
                // tabla.inicia(10);
                // tabla.inicia(partida.tamanyoTablero);
                tabla.inicia();
        }

        if(partida.tamanyoTablero==8){
            for(let i =0; i<partida.tamanyoTablero;i++){
            $( ".tablero" ).append( "<div class='fila'></div>" );
            $(".fila").css("height","12.5%");
            }

            $( ".fila" ).each(function( index ) {
                $( ".fila" ).append( "<div class='columna'></div>" );
            });

            for(let y=0; y<8;y++){

                var children = $( ".fila" ).eq( y ).children();
                
                    for(let m=0;m<children.length;m++){
                        children[m].setAttribute("id","r"+y +"c"+m);
                
                    }
                }
                // tabla.inicia(8);
                console.log(partida.tamanyoTablero);
                // tabla.inicia(partida.tamanyoTablero);
                tabla.inicia();
        }

        // $( ".micheckbox" ).click(function() {
                
        //     // console.log("lenght click:"+tabla.arrayMoves);

        //     // let r = parseInt(this.getAttribute("id").charAt(1));
        //     // let c = parseInt(this.getAttribute("id").charAt(3));
        //     console.log("chech"+ this.value);
            
        //     // let fitxas = [];
        //     // fitxas = tabla.arrayMoves;
        //     // // console.log(fitxas);
        //     // if(fitxas.includes(r+" "+c)){
        //     //     //comprobamos todos loa arrays guadados anterior mente i si alguno contiene r i c nos lo cargamos entero
        //     //     alert("tiene");
        //     //     // console.log(r+" "+c);
        //     //     tabla.gira(r,c);
                
        //     // }else{
        //     //     alert("movimiento invalido");
        //     // }
            

        
        // });

                $( ".columna" ).click(function() {
                
                    // console.log("lenght click:"+tabla.arrayMoves);

                    let r = parseInt(this.getAttribute("id").charAt(1));
                    let c = parseInt(this.getAttribute("id").charAt(3));

                    
                    let fitxas = [];
                    fitxas = tabla.arrayMoves;
                    // console.log(fitxas);
                    if(fitxas.includes(r+" "+c)){
                        //comprobamos todos loa arrays guadados anterior mente i si alguno contiene r i c nos lo cargamos entero
                        alert("tiene");
                        // console.log(r+" "+c);
                        tabla.gira(r,c);
                        
                    }else{
                        alert("movimiento invalido");
                    }
                    
        
                
                });



                
    }
}

  
            
                    
  
