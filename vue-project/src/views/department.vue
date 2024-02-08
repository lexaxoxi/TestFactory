<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const url = 'http://localhost:8080/api/department'

const departments = ref([]);

const fetchDepartment = () => {
    getDepartment(url);
};

const getDepartment = async (url) => {
    await axios.get(url)
        .then(response => {
            departments.value = response.data.map(department => ({
                id: department.id,
                title: department.title,
                department: department.department,
                note: department.note,
                parent_id: department.parent_id

            }));
            console.log('Список получен');
        })
        .catch(error => {
            console.error(error);
        });
};

const deleteDepartment = (Id) => {
    axios.delete(url + '/' + Id)
        .then(response => {
            console.log('Успешное удаление:', response.data);
            fetchDepartment();
        })
        .catch(error => {
            console.error('Ошибка при удалении:', error);
        });
};

const editDepartment = (Id) => {
    axios.put(url + '/' + Id)
        .then(response => {
            console.log('Успешное отредактирование:', response.data);
            fetchDepartment();
        })
        .catch(error => {
            console.error('Ошибка при редактировании:', error);
        });
};

const review = ref({
    title: '',
    department: '',
    note: '',
    parent_id: ''
})

const createDepartment = () => {
    const postData = {
        title: review.value.title,
        department: review.value.department,
        note: review.value.note,
        parent_id: review.value.parent_id
    };
    postDepartment(url, postData);
};

const postDepartment = async (url, data) => {
    try {
        const response = await axios.post(url, data);
        console.log('Успешный ответ:', response.data);
        fetchDepartment();

        return response.data;
    } catch (error) {
        console.error('Ошибка при отправке POST-запроса:', error);
        throw error;
    }
};

onMounted(() => {
    fetchDepartment();
});

</script>

<template>
    <div class="general">
        <h4>Отдел</h4>
        <div>
            <input v-model="review.title "placeholder="Наименование">
            <input v-model="review.department "placeholder="Родительский Отдел">
            <input v-model="review.note "placeholder="Примечание">
            <button @click="createDepartment()">Создать</button>
        </div>
        <table>
            <tr>
                <th>Наименование</th>
                <th>РодительскийОтдел</th>
                <th>Примечание</th>
            </tr>
            <tr v-for="department in  departments " :key="department.id">
                <td>{{ department.title }}</td>
                <td>{{ department.department }}</td>
                <td>{{ department.note }}</td>
                <td>{{ department.parent_id }}</td>
                <td>
                    <button @click="editDepartment(department.id)">Отредактировать</button>
                    <button @click="deleteDepartment(department.id)">Удалить</button>
                </td>
            </tr>
        </table>
    </div>
</template>