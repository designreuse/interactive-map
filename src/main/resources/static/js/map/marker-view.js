
   function viewPoint(ob_lat, ob_lng) {
    layer = L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '<style="font-size:2">&copy; imaginalis</style>'});
    latlng = new L.LatLng(ob_lat,ob_lng);
    map = new L.Map('map', {center: latlng, zoom:10, zoomControl:true, layers: [layer], scrollWheelZoom : true});
       var icon = L.icon({
           iconUrl: '../../../images/marker24.png',
           iconSize: [25, 41],
           iconAnchor: [25, 41],
           popupAnchor: [-12, -38]
       });
       marker = new L.marker(latlng,{draggable:false});
       marker.setIcon(icon);
       map.addLayer(marker);
   };

