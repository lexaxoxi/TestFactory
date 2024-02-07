<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const url = 'http://localhost:8080/api/employees'

const departsments = ref([]);

const fetchDepartsment = () => {
    getDepartsment(url);
};

const getDepartsment = async (url) => {
    await axios.get(url)
        .then(response => {
            departsments.value = response.data.map(departsment => ({
                id: departsment.id,
                title: departsment.profession.title,
                department: departsment.department,
                note: departsment.note
            }));
            console.log('Список получен');
        })
        .catch(error => {
            console.error(error);
        });
};

const deleteDepartsment = (Id) => {
    axios.delete(url + '/' + Id)
        .then(response => {
            console.log('Успешное удаление:', response.data);
            fetchDepartsment();
        })
        .catch(error => {
            console.error('Ошибка при удалении:', error);
        });
};

const editDepartsment = (Id) => {
    axios.edit(url + '/' + Id)
        .then(response => {
            console.log('Успешное отредактирование:', response.data);
            fetchDepartsment();
        })
        .catch(error => {
            console.error('Ошибка при редактировании:', error);
        });
};

const review = ref({
    title: '',
    department: '',
    note: ''
})

const createDepartsment = () => {
    const postData = {
        title: review.value.title,
        department: review.value.department,
        note: review.value.note
    };
    postDepartsment(url, postData);
};

const postDepartsment = async (url, data) => {
    try {
        const response = await axios.post(url, data);
        console.log('Успешный ответ:', response.data);
        fetchDepartsment();

        return response.data;
    } catch (error) {
        console.error('Ошибка при отправке POST-запроса:', error);
        throw error;
    }
};

onMounted(() => {
    fetchDepartsment();
});

</script>

<template>
    <div class="general">
        <h4>Отдел</h4>
        <div>
            <input placeholder="Наименование">
            <input placeholder="Департамент">
            <input placeholder="Примечание">
            <button @click="createDepartsment()">Создать</button>
        </div>
        <table>
            <tr>
                <td>Наименование</td>
                <td>Департамент</td>
                <td>Примечание</td>
            </tr>
            <tr v-for="departsment in  departsments " :key="departsment.id">
                <td>{{ departsment.profession }}</td>
                <td>{{ departsment.department }}</td>
                <td>{{ departsment.note }}</td>
                <td>
                    <button @click="editDepartsment(departsment.id)">Отредактировать</button>
                    <button @click="deleteDepartsment(departsment.id)">Удалить</button>
                </td>
            </tr>
        </table>
    </div>
</template>