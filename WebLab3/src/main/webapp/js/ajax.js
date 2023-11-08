
function getUnits(tableId, type) {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "allUnitsServlet?type="+type, true);
  xhttp.send();
}

function getCookies(divID) {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(divID).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "cookiesServlet", true);
  xhttp.send();
}

function getResult(input,unit,result) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(result).innerHTML = this.responseText;
    }
  };
  let number = document.getElementById(input).value;
  let numberToSend = number ? number : "brak";
  xhttp.open("GET", "calculateServlet?number=" +  numberToSend + "&unit="+document.getElementById(unit).value, true);
  xhttp.send();
}
