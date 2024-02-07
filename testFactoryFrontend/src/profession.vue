<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const url = 'http://localhost:8080/api/employees'

const professions = ref([]);

const fetchProfession = () => {
    getProfession(url);
};

const getProfession = async (url) => {
    await axios.get(url)
        .then(response => {
            professions.value = response.data.map(profession => ({
                id: profession.id,
                title: profession.title,
                note: profession.note
            }));
            console.log('Список получен');
        })
        .catch(error => {
            console.error(error);
        });
};

const deleteProfession = (Id) => {
    axios.delete(url + '/' + Id)
        .then(response => {
            console.log('Успешное удаление:', response.data);
            fetchProfession();
        })
        .catch(error => {
            console.error('Ошибка при удалении:', error);
        });
};

const editProfession = (Id) => {
    axios.edit(url + '/' + Id)
        .then(response => {
            console.log('Успешное отредактирование:', response.data);
            fetchProfession();
        })
        .catch(error => {
            console.error('Ошибка при редактировании:', error);
        });
};

const review = ref({
    title: '',
    note: ''
})

const createProfession = () => {
    const postData = {
        title: review.value.title,
        note: review.value.note
    };
    postProfession(url, postData);
};

const postProfession = async (url, data) => {
    try {
        const response = await axios.post(url, data);
        console.log('Успешный ответ:', response.data);
        fetchProfession();

        return response.data;
    } catch (error) {
        console.error('Ошибка при отправке POST-запроса:', error);
        throw error;
    }
};


onMounted(() => {
    fetchProfession();
});

</script>

<template>
    <div class="general">
        <h4>Профессия</h4>
        <div>
            <input placeholder="Наименование">
            <input placeholder="Примечание">
        <button @click="createProfession()">Создать</button>
        </div>
        <table>
            <tr>
                <td>Наименование</td>
                <td>Примечание</td>
            </tr>
            <tr v-for="profession in  professions " :key="profession.id">
                <td>{{ professions.profession }}</td>
                <td>{{ professions.note }}</td>
                <td>
                    <button @click="editProfession(profession.id)">Отредактировать</button>
                    <button @click="deleteProfession(profession.id)">Удалить</button>
                </td>
            </tr>
        </table>
    </div>
</template>