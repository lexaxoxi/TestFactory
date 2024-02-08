<script setup>
import { ref } from 'vue'
import employee from './views/employee.vue'
import department from './views/department.vue'
import profession from './views/profession.vue'

const chapter = ref("none")

const change = (name) => {
  chapter.value = name
}
</script>

<template>
  <div class="general-form">
    <div class="menu">
      <button class="menu-button" v-on:click="change('employee')">Сотрудник</button>
      <button class="menu-button" v-on:click="change('department')">Отдел</button>
      <button class="menu-button" v-on:click="change('profession')">Профессия</button>
    </div>
    <div class="function">
      <employee v-show="chapter === 'employee'" />
      <department v-show="chapter === 'department'" />
      <profession v-show="chapter === 'profession'" />
    </div>
  </div>
</template>

<style scoped>
.menu {
  width: 100%;
  height: 20%;
  background-color: transparent;
}

.menu-button {
  width: 30%;
  height: 100%;
  margin-left: 3%;
}

.function {
  width: 100%;
  height: 80%;
  background-color: transparent;
}
</style>
