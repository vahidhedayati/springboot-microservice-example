<template>
  <div class="home">
    <QueryForm  />
  </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component'
import QueryForm from '@/components/QueryForm.vue'

@Options({
  components: {
    QueryForm
  }
})
export default class Home extends Vue {}
</script>
