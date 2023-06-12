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
  L.marker([lat, lon]).addTo(map);

  const position = {
    lat: lat,
    lon: lon
  };
    console.log(`position.json = ${JSON.stringify(position)}`);
  fetch('/api/v1/savePlace', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'X-XSRF-TOKEN': '',
    },
    body: JSON.stringify(position)
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