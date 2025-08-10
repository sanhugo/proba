document.addEventListener("DOMContentLoaded", function() {
    const citySelect = document.getElementById("citySelect");
    const tableBody = document.querySelector("#buildingsTable tbody");

    // Загружаем список городов
    fetch("/api/cities/active")
        .then(r => r.json())
        .then(cities => {
            cities.forEach(city => {
                const option = document.createElement("option");
                option.value = city.id;
                option.textContent = city.name;
                citySelect.appendChild(option);
            });
        });

    // При выборе города — загрузка зданий
    citySelect.addEventListener("change", loadBuildings);

    // Функция загрузки зданий
    function loadBuildings() {
        const cityId = citySelect.value;
        let url = "/api/buildings";
        if (cityId && cityId !== "all") {
            url += `?cityId=${cityId}`;
        }

        fetch(url)
            .then(r => r.json())
            .then(buildings => {
                tableBody.innerHTML = ""; // очищаем таблицу
                buildings.forEach(b => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${b.address}</td>
                        <td>${b.description}</td>
                        <td>
                            <button class="btn ${b.active ? 'btn-danger' : 'btn-success'}"
                                    data-id="${b.id}"
                                    data-active="${b.active}">
                                    ${b.active ? 'Деактивировать' : 'Активировать'}
                            </button>
                        </td>
                    `;
                    tableBody.appendChild(row);
                });

                // Вешаем обработчики на кнопки
                tableBody.querySelectorAll("button").forEach(btn => {
                    btn.addEventListener("click", function() {
                        const buildingId = this.dataset.id;
                        const active = this.dataset.active === "true";
                        const action = active ? "deactivate" : "activate";

                        fetch(`/api/buildings/${action}`, {
                            method: "POST",
                            headers: { "Content-Type": "application/json" },
                            body: JSON.stringify({ buildingId })
                        })
                            .then(() => loadBuildings()); // перезагружаем список
                    });
                });
            });
    }

    // Загружаем все здания при открытии
    loadBuildings();
});

