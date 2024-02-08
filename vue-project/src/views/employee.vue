<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const url = 'http://localhost:8080/api/employees'

const employees = ref([]);

const fetchEmployee = () => {
    getEmployee(url);
};

const getEmployee = async (url) => {
    await axios.get(url)
        .then(response => {
            employees.value = response.data.map(employee => ({
                id: employee.id,
                fio: employee.fio,
                profession: employee.profession.title,
                department: employee.department,
                note: employee.note
            }));
            console.log('Список получен');
        })
        .catch(error => {
            console.error(error);
        });
};

const deleteEmployee = (Id) => {
    axios.delete(url + '/' + Id)
        .then(response => {
            console.log('Успешное удаление:', response.data);
            fetchEmployee();
        })
        .catch(error => {
            console.error('Ошибка при удалении:', error);
        });
};

const review = ref({
    fio: '',
    profession: '',
    department: '',
    note: ''
})

const createEmployee = () => {
    const postData = {
        fio: review.value.fio,
        profession: review.value.profession,
        department: review.value.department,
        note: review.value.note
    };
  console.log(postData);
    postEmployee(url, postData);
};

const postEmployee = async (url, data) => {
    try {
        const response = await axios.post(url, data);
        console.log('Успешный ответ:', response.data);
        fetchEmployee();

        return response.data;
    } catch (error) {
        console.error('Ошибка при отправке POST-запроса:', error);
        throw error;
    }
};

const edit = ref({
    id: '',
    fio: '',
    profession: '',
    department: '',
    note: ''
})

const editForm = ref(false)

const editFunction = async (Id)=> {
    await axios.get(url + '/' + Id)
        .then(response => {
            edit.value = response.data.map(employee => ({
                id: employee.id,
                fio: employee.fio,
                profession: employee.profession.title,
                department: employee.department,
                note: employee.note
            }));
            console.log('Список получен');
        })
        .catch(error => {
            console.error(error);
        });
}

const editEmployee = (Id) => {
    axios.put(url + '/' + Id)
        .then(response => {
            console.log('Успешное отредактирование:', response.data);
            fetchEmployee();
        })
        .catch(error => {
            console.error('Ошибка при редактировании:', error);
        });
};

onMounted(() => {
    fetchEmployee();
});


</script>

<template>
    <div class="general">
        <h4>Сотрудник</h4>
        <div>
            <input v-model="review.fio "placeholder="ФИО">
            <input v-model="review.profession "placeholder="Профессия">
            <input v-model="review.department "placeholder="Отдел">
            <input v-model="review.note "placeholder="Примечание">
        <button @click="createEmployee()">Создать</button>
        </div>
        <form v-show="editForm" class="submit-form">
            <input v-model="edit.fio" placeholder="ФИО">
            <input v-model="edit.profession" placeholder="Профессия">
            <input v-model="edit.department" placeholder="Отдел">
            <input v-model="edit.note" placeholder="Примечание">
            <button @click="edit!=editForm">Сохранить</button>
        </form>
        <table>
          <tr>
            <th>ФИО</th>
            <th>Профессия</th>
            <th>Отдел</th>
            <th>Примечание</th>
          </tr>
            <tr v-for="employee in  employees " :key="employee.id">
                <td>{{ employee.fio }}</td>
                <td>{{ employee.profession }}</td>
                <td>{{ employee.department }}</td>
                <td>{{ employee.note }}</td>
                <td>
<!--                    <button @click="editEmployee(employee.id)">Редактировать</button>-->
                    <button @click="editEmployee(employee.id)">Сохранить</button>
                    <button @click="deleteEmployee(employee.id)">Удалить</button>
                </td>
            </tr>
        </table>
    </div>
</template>



