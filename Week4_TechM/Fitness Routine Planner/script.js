function openPage(page) {
    window.open(page, '_blank'); // Opens in a new tab
}

let routines = JSON.parse(localStorage.getItem('routines')) || [];


function addExercise() {
    const name = document.getElementById('exerciseName').value;
    const duration = document.getElementById('duration').value;
    if (name && duration) {
        routines.push({ name, duration, completed: false });
        localStorage.setItem('routines', JSON.stringify(routines));
        document.getElementById('exerciseName').value = '';
        document.getElementById('duration').value = '';
        document.getElementById('successMessage').style.display = 'block';
        setTimeout(() => {
            document.getElementById('successMessage').style.display = 'none';
        }, 2000);
    }
}


function displayRoutines() {
    const list = document.getElementById('routineList');
    if (!list) return; 
    list.innerHTML = '';

    routines.forEach((routine, index) => {
        const li = document.createElement('li');
        li.classList.add('routine-item');
        li.innerHTML = `
            <span class="${routine.completed ? 'completed' : ''}" onclick="toggleCompletion(${index})">
                ${routine.name} - ${routine.duration} min
            </span>
            <button class="delete-btn" onclick="deleteRoutine(${index})">❌</button>
        `;
        list.appendChild(li);
    });
}


function toggleCompletion(index) {
    routines[index].completed = !routines[index].completed;
    localStorage.setItem('routines', JSON.stringify(routines));
    displayRoutines();
}


function deleteRoutine(index) {
    routines.splice(index, 1);
    localStorage.setItem('routines', JSON.stringify(routines));
    displayRoutines();
}


document.addEventListener("DOMContentLoaded", displayRoutines);


document.addEventListener("DOMContentLoaded", () => {
    displayProgressChart();
});

let progressData = JSON.parse(localStorage.getItem('progress')) || { dates: [], weights: [] };


function addProgress() {
    const weight = document.getElementById('weight').value;
    if (weight) {
        const today = new Date().toLocaleDateString();
        progressData.dates.push(today);
        progressData.weights.push(parseFloat(weight));

        localStorage.setItem('progress', JSON.stringify(progressData));
        displayProgressChart();
    }
}


function displayProgressChart() {
    const ctx = document.getElementById('progressChart').getContext('2d');
    
    if (window.progressChartInstance) {
        window.progressChartInstance.destroy();
    }

    window.progressChartInstance = new Chart(ctx, {
        type: 'line',
        data: {
            labels: progressData.dates,
            datasets: [{
                label: 'Weight (kg)',
                data: progressData.weights,
                borderColor: 'rgb(75, 192, 192)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderWidth: 2,
                fill: true,
                tension: 0.1
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: false
                }
            }
        }
    });
}
