<template>
  <header class="header">
    <nav class="menu">
      <ul class="menu-left">
        <li>
          <img title="Tada todo list" src="../assets/logo.png" height="60" />
        </li>
        <li class="">Test SpringBoot Microservices (Non Blocking calls)</li>
      </ul>
      <ul class="menu-right">
        <li><router-link to="/">Home</router-link></li>
        <li class="btn btn-blue">
          <router-link to="/about">About</router-link>
        </li>
      </ul>
    </nav>
  </header>
</template>
<style scoped>
.header {
  border: solid 1px #000;
  background: #330000;
  color: #fff;
  clear: both;
}

.header a {
  color: #fff;
  padding-right: 5px;
  text-decoration: none;
}

nav.menu {
  display: flex;
  justify-content: space-between;
}
nav.menu ul {
  margin: 0;
  padding: 0;
  list-style: none;
}
nav.menu ul li {
  display: inline-block;
}
</style>
