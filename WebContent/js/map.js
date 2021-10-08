

function initMap(){
    const map = new google.maps.Map(
        document.getElementById('space'),{
            center: {
                lat: 37.551073, 
                lng: 126.987893
            },
            zoom:15,
        }
    );
    new google.maps.Marker({
        position: {
            lat: 37.551073, 
            lng: 126.987893
        },
        map:map,
        label: "here"
    })
}