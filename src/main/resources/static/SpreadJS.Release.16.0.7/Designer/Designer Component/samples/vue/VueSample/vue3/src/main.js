import { createApp } from 'vue'
import App from './App.vue'
import Designer from "@grapecity/spread-sheets-designer-vue"
let app = createApp(App);
app.component("gc-spread-sheets-designer", Designer);
app.mount('#app')
