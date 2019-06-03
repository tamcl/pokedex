$(document).ready(function(){
  loadAllPokemon(); //load all pokemon when page first load

  $("h1").click(function(){ //reload the page when clicked on the header
    location.reload();
  });

  $(".display").on("click", ".pokemonName", function(){ //load specific pokemon info when clicked on pokemon name
    var id = $(this).parent().attr("id");
    loadSpecificPokemon(id);
  });

});

function loadAllPokemon(){
  //call api to get all pokemon name
  $.get("https://pokeapi.co/api/v2/pokemon/?limit=807&offset=0", function(data,status){
    for (index in data.results){
      //create HTML code for a row with pokedex no. and name of the pokemon
      var allPokemonHTML = "";
      allPokemonHTML += "<p id='" + (parseInt(index)+1) + "'>" + addAppendingZeros(parseInt(index)+1);
      allPokemonHTML += " <span class='pokemonName'>"+ data.results[index].name + "</span><br>";
      allPokemonHTML += "</p>";
      //append the code to the end of .display div
      $(".display").append(allPokemonHTML);
    }
  });
}

function addAppendingZeros(n){
  if(0 <= n && 10 > n){
    return "00" + n;
  }
  else if(10 <= n && 100 > n){
    return "0" + n;
  }
  else return n;
}

function loadSpecificPokemon(id){
  console.log(typeof id);
  $(".display").html(""); //clear content in .display div
  //call api to get the info of the specific pokemon
  $.get("https://pokeapi.co/api/v2/pokemon/" + id, function(data, status){
    //create HTML code for all info of the specific pokemon
    specificPokemonHTML = "";
    specificPokemonHTML += "<img src='" + data.sprites.front_default + "' alt='image'>";
    //put the code into .display div
    $(".display").html(specificPokemonHTML);
  });
}
