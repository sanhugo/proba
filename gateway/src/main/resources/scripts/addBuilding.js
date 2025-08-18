document.addEventListener('DOMContentLoaded', () => {
    const citySelect = document.getElementById('city');
const form = document.getElementById('buildingForm');

    fetch('/api/cities/active')
        .then(response => response.json())
        .then(data => {
            data.forEach(tz => {
                const option = document.createElement('option');
                option.value = tz.id;
                option.textContent = tz.name;
                citySelect.appendChild(option);
            });
        });

form.addEventListener('submit', (e) => {
    e.preventDefault();

    const buildingDTO = {
        city_id: document.getElementById('city').value,
        address: document.getElementById('address').value,
        description: document.getElementById('description').value
    };

    fetch('/api/buildings/add', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(buildingDTO)
    })
        .then(response => {
            if (response.ok) {
                alert('Здание успешно добавлено!');
            } else {
                alert('Ошибка при добавлении города');
            }
        });
    form.reset();
});
});