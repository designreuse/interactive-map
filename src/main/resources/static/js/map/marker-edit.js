$(document).ready(function() {

    layer = L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '<style="font-size:2">&copy; imaginalis</style>'});
    latlng = new L.LatLng(53.64371519760825,18.176193237304684);
    boryMap = new L.Map('map', {center: latlng, zoom:10, zoomControl:true, layers: [layer], scrollWheelZoom : true});
    boryMap.on('click', function(e) {
        if(typeof newMarker != 'undefined'){
            boryMap.removeLayer(newMarker);
        }
        newMarker = new L.marker(e.latlng,{draggable:true});
        newMarker.setIcon(icon);
        boryMap.addLayer(newMarker);
        (document.getElementById("lat").value) = e.latlng.lat;
        (document.getElementById("lng").value) = e.latlng.lng;
        newMarker.on('dragend', function(e){
            (document.getElementById("lat").value) = e.target.getLatLng().lat;
            (document.getElementById("lng").value) = e.target.getLatLng().lng;
        });
    });
    var icon = L.icon({
        iconUrl: '../../../images/marker24.png',
        iconSize: [70, 70],
        iconAnchor: [36, 48],
        popupAnchor: [0, -25]
    });
//Edycja istniejacego
    if(document.getElementById("lat")){
        if(typeof (document.getElementById("lat").value && document.getElementById("lng").value) != 'undefined'){

            latlng = new L.LatLng(document.getElementById("lat").value,document.getElementById("lng").value);
            newMarker = new L.marker(latlng,{draggable:true});
            newMarker.setIcon(icon);
            boryMap.addLayer(newMarker);
            boryMap.panTo(newMarker.getLatLng());
        }
    }
});


function naMape(){
    var parametr = $("#location").val();
    var url = "https://maps.googleapis.com/maps/api/geocode/json?address="+parametr+"&sensor=true";
    $.getJSON(url, function(data)
    {
        if(typeof data.results[0] != 'undefined'){
            $("#location").val((data.results[0].formatted_address).toString());
            console.log(data.results[0]);
            $("#lat").val(data.results[0].geometry.location.lat);
            $("#lng").val(data.results[0].geometry.location.lng);
            window.lat = data.results[0].geometry.location.lat;
            window.lng = data.results[0].geometry.location.lng;
            if(typeof newMarker === 'undefined'){
                latlng = new L.LatLng(window.lat,window.lng);
                newMarker = new L.marker(latlng,{draggable:true});
                var icon = L.icon({
                    iconUrl: '../../../images/marker24.png',
                    iconSize: [70, 70],
                    iconAnchor: [36, 48],
                    popupAnchor: [0, -25]
                });
                newMarker.setIcon(icon);
                boryMap.addLayer(newMarker);
                boryMap.panTo(newMarker.getLatLng());
                boryMap.setView(newMarker.getLatLng(), 16);

            }
            else{
                boryMap.removeLayer(newMarker);
                latlng = new L.LatLng(window.lat,window.lng);
                newMarker = new L.marker(latlng,{draggable:true});
                var icon = L.icon({
                    iconUrl: '../../../images/marker24.png',
                    iconSize: [70, 70],
                    iconAnchor: [36, 48],
                    popupAnchor: [0, -25]
                });
                newMarker.setIcon(icon);
                boryMap.addLayer(newMarker);
                boryMap.panTo(newMarker.getLatLng());
                boryMap.setView(newMarker.getLatLng(), 16);

            }
        }
        else{
            alert("Pole \'Lokalizacja\' jest puste bądź nie można zlokalizować podanego adresu");
        }
    });
}
