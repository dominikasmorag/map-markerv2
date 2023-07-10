var map = L.map('map').setView([51.505, -0.09], 13);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  attribution: 'Map data © <a href="https://openstreetmap.org">OpenStreetMap</a> contributors'
}).addTo(map);

var LeafIcon = L.Icon.extend({
    options: {
    iconSize: [38, 40],
    iconAnchor: [22, 40],
    shadowAnchor: [4, 42],
    popupAnchor: [-3, -76]
    }
});

var gasolineIcon = new LeafIcon({
    iconUrl: 'leaflet-icons/gasoline-pump.png'
    });

var heartIcon = new LeafIcon({
    iconUrl: 'leaflet-icons/heart.png'
    });

var museumIcon = new LeafIcon({
    iconUrl: 'leaflet-icons/museum.png'
    });

var parkingIcon = new LeafIcon({
    iconUrl: 'leaflet-icons/parking.png'
    });

var restaurantIcon = new LeafIcon({
    iconUrl: 'leaflet-icons/restaurant.png'
    });

var shoppingCartIcon = new LeafIcon({
    iconUrl: 'leaflet-icons/shopping-cart.png'
    });

var icons = [];
icons.push(gasolineIcon, heartIcon, museumIcon, parkingIcon, restaurantIcon, shoppingCartIcon);
console.log('DUPAAAAAAAAAAAAAAAAA@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@' + JSON.stringify(icons));

//undefined
var nanana = icons.find(ic => ic.iconUrl === 'leaflet-icons/shopping-cart.png')
console.log(nanana);

var marker = L.marker([51.521562, -0.304184], {icon: gasolineIcon}).addTo(map);

var userId;

fetch('/api/v1/user/current')
.then(function(response) {
    if(!response.ok) {
    throw new Error('Network response error');
    console.log('Network response error while getting /api/v1/user/current');
    }
    return response.json();
    })
    .then(function(data) {
    userId = data;

    })
    .catch(function(error) {
    console.log('Error: ', error);
    });


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
  L.marker([lat, lon], {icon: gasolineIcon}).addTo(map);

   const place = {
       name: placeName,
       description: placeDescription,
       position: {
       lat: lat,
       lon: lon
       },
       shared: shared
   };

console.log(userId);

fetch('/api/v1/places/myPlaces')
    .then(response => response.json())
    .then(data => {
    const userPlaces = JSON.stringify(data);
    console.log(userPlaces);
    const userPlacesArr = JSON.parse(userPlaces);
    console.log(userPlacesArr);
    userPlacesArr.forEach(addToMap)
    })
    .catch(error => {
    console.error('Error while trying to fetch /api/v1/places/myPlaces');
    });

    function addToMap(userPlace) {
    const latt = userPlace.position.lat;
    const lonn = userPlace.position.lon;

    L.marker([parseFloat(latt), parseFloat(lonn)]).addTo(map);

    }

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