document.addEventListener('DOMContentLoaded', () => {
    const timezoneSelect = document.getElementById('timezone');
    const form = document.getElementById('cityForm');

    // Загружаем список часовых поясов
    fetch('/api/timezones')
        .then(response => response.json())
        .then(data => {
            data.forEach(tz => {
                const option = document.createElement('option');
                option.value = tz;
                option.textContent = tz;
                timezoneSelect.appendChild(option);
            });
        });

    // Отправка формы в JSON
    form.addEventListener('submit', (e) => {
        e.preventDefault();

        const cityDto = {
            name: document.getElementById('name').value,
            timezone: timezoneSelect.value
        };

        fetch('/api/cities/add', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(cityDto)
        })
            .then(response => {
                if (response.ok) {
                    alert('Город успешно добавлен!');
                } else {
                    alert('Ошибка при добавлении города');
                }
            });
        form.reset();
    });
});