var map = L.map('map').setView([51.505, -0.09], 13);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  attribution: 'Map data © <a href="https://openstreetmap.org">OpenStreetMap</a> contributors'
}).addTo(map);

var marker = L.marker([51.521562, -0.304184]).addTo(map);

function onMapClick(e) {
  var latlng = e.latlng;
  marker.setLatLng(latlng);
  marker.bindPopup("Coordinates: " + latlng.lat.toFixed(6) + ", " + latlng.lng.toFixed(6)).openPopup();
}

map.on('click', onMapClick);

const saveButton = document.getElementById("saveButton");
saveButton.addEventListener("click", () => {
  const lat = marker.getLatLng().lat.toFixed(6);
  const lon = marker.getLatLng().lng.toFixed(6);
  const placeName = document.getElementById("locationName").value;
  const placeDescription = document.getElementById("locationDescription").value;
  const checkbox = document.getElementById("shared");
  const shared = checkbox.checked;
  console.log("SHARED OR NOT SHARED? " + shared)
  L.marker([lat, lon]).addTo(map);

//  const place = {
//    lat: lat,
//    lon: lon
//  };

   const place = {
       name: placeName,
       description: placeDescription,
       position: {
       lat: lat,
       lon: lon
       },
       shared: shared
   };

//  String name, String description, Position position, boolean shared
    console.log(`place.json = ${JSON.stringify(place)}`);
  fetch('/api/v1/savePlace', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'X-XSRF-TOKEN': '',
    },
    body: JSON.stringify(place)
  })
  .then(response => {
  console.log('response', response)
    if (response.ok) {
      console.log('Location saved successfully!');
    } else {
      console.log('Error saving location:', response.statusText);
    }
  })
  .catch(error => console.log('Error requesting saving location:', error));
});

marker.on('mouseover', function (e) {
  var latlng = marker.getLatLng();
  var tooltip = L.tooltip({
    direction: 'top',
    permanent: true,
    interactive: false,
    opacity: 0.7
  }).setContent("Coordinates: " + latlng.lat.toFixed(6) + ", " + latlng.lng.toFixed(6));
  marker.bindTooltip(tooltip).openTooltip();
});

marker.on('mouseout', function (e) {
  marker.unbindTooltip();
});