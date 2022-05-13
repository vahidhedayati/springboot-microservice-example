<template>
  <formpanel class="queryForm">
    <h2>Query Backend</h2>
      <div class="row">
      <label :for="entry" v-for="([entry, val]) in Object.entries(arrayobject)" :key="entry">{{ entry }}
      <input
        type="checkbox"
        v-model="arrayobject[entry]"
        :checked="val"
      />
      </label>
      </div>
    <div class="">
      <label for="elementField">Amount of elements (arraySize)</label>
      <input type="number"  id="elementField" v-model="elements"/>
      <label for="textField">Text content of each entry that will be generated</label>
      <input type="text"  id="textField" v-model="text"/>
      <label for="queryIdField">Query An Entry? (Give an numberic id within above element array size)</label>
      <input type="number"  id="queryIdField" v-model="queryId"/>
      <label for="deleteIdField">Delete An Entry? (Give an numberic id within above element array size)</label>
      <input type="number"  id="deleteIdField" v-model="deleteId"/>
      <input type="submit" @click="triggerBackEnd" value="Trigger non blocking call"/>
    </div>
  </formpanel>
  <div class="results">
    <div class="resultPane" :class="{ resultPanel: i%4===0 }" v-for="([entry, val], i) in Object.entries(arrayobject)" :ref="entry" :key="entry" :id="entry">
      Awaiting result for {{entry}} currently set to {{val}} {{i}}
      <div :id="entry+'Post'" class="newRow" :ref="entry+'Post'"></div>
      <div :id="entry+'Get'"  class="newRow"  :ref="entry+'Get'"></div>
      <div :id="entry+'Delete'"  class="newRow"  :ref="entry+'Delete'"></div>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue } from 'vue-class-component'
export default class QueryForm extends Vue {
  elements= 10000
  text='Some array text'
  queryId= '5'
  deleteId= '6'
  myobject=['d']
  arrayobject={ arrayList: true, linkList: true, stringArray: true, arrayBlockingList: true, treeSet: true, stack: true, hashSet: true, hashMap: true, treeHashMap: true, concurrentHashMap: true }
  mounted () {
    console.log('mounted calling................')
    return true
  }

  triggerBackEnd () {
    console.log('mounted calling................')
    const generateBody = { elements: this.elements, text: this.text }
    for (const [key, value] of Object.entries(this.arrayobject)) {
      // console.log(key + ' has ' + value)
      if (value === true) {
        this.fetchPost(key, generateBody)
        if (this.queryId !== '') {
          this.fetchGet(key)
        }
        if (this.deleteId !== '') {
          this.fetchDelete(key)
        }
      }
    }
    return true
  }

  fetchGet (methodName:string) {
    const responseDiv = methodName + 'Get'
    fetch('http://localhost:8085/' + methodName + '/' + this.queryId, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(response => response.json())
      .then(data => {
        (this.$refs[responseDiv] as any)[0].innerHTML = JSON.stringify(data)
      })
  }

  fetchDelete (methodName:string) {
    const responseDiv = methodName + 'Delete'
    fetch('http://localhost:8085/' + methodName + '/' + this.deleteId, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(response => response.json())
      .then(data => {
        (this.$refs[responseDiv] as any)[0].innerHTML = JSON.stringify(data)
      })
    return true
  }

  fetchPost (methodName:string, body:any) {
    const responseDiv = methodName + 'Post'
    // console.log('REFS are' + JSON.stringify(this.$refs))
    // this.$nextTick(() => {
    fetch('http://localhost:8085/' + methodName + '/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(body)
    }).then(response => response.json())
      .then(data => {
        (this.$refs[responseDiv] as any)[0].innerHTML = JSON.stringify(data)
      })
    // })
  }
}
</script>
<style scoped>
.row {
  padding-bottom: 8px;
}
.newRow {
  width: 100%;
  margin-top:20px;
  word-wrap: break-word;
  flex-wrap: wrap;
}
.resultPane {
  width: 400px;
  height: 400px;
  margin: 10px;
  border: solid 1px #000;
}
.results {
  padding: 20px;
  display: flex;
  flex-flow: row wrap;
  justify-content: normal;
}
.row label {
  margin-left: 1em;
  margin-right: 1em;
}
formpanel input {
  margin-left: 0.5em;
  margin-right: 0.5em;
}
formpanel {
  border: solid 1px #000;
  background: #FEFEFA;
  color: #330000;
  display: flex;
  flex-direction: column;
}
</style>
