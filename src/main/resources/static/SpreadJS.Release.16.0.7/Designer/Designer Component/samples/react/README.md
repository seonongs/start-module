# GC.Spread.Sheets.Designer Wrapper for React

For complete information on how you can customize the Designer, refer to our online documentation - https://www.grapecity.com/spreadjs/docs/v14/online/spreadjs_designer_components.html

### `npm install`
The dependencies required to install

### `npm run start`
The dependencies required to start sample

### SpreadJS Designer React Wrapper Component Markup
```js
<Designer></Designer>
```

**styleInfo prop** Pass styleInfo to the component props to customize the designer's style.
```js
<Designer styleInfo = {{width: "1500px", height: '90vh'}}  spreadOptions = {{sheetCount: 2}}></Designer>
```

**config prop** Pass in the custom **config** to customize the Designer.
```js
<Designer config = {customConfig()}></Designer>

function customConfig() {
    //config import from local
    config.ribbon[0].buttonGroups.unshift(
        {
            "label":"NewDesigner",
            "thumbnailClass":"welcome",
            "commandGroup":{
                "children":[
                    {
                        "direction":"vertical",
                        "commands":[
                            "Welcome"
                        ]
                    }
                ]
            }
        }
    );
    let customCommand = {
        title: "Welcome",
        text: "Welcome",
        iconClass: "ribbon-button-welcome",
        bigButton: "true",
        commandName: "Welcome",
        execute: async (context, propertyName) => {
            alert('Welcome to new designer.');
        }
    }
    config.commandMap = {
        Welcome: customCommand
    }
    return config;
}
```
**designerInitialized event** Fired after instantiation.
```js
<Designer designerInitialized = {designer => {getDesigner(designer)}}></Designer>

function getDesigner(designer) {
    //this is designer instance
    console.log(designer);
}
```


**Apply License** You can register the below code in the App.js file.
```js
//In src/App.js file
import '@grapecity/spread-sheets-designer-resources-en';
import * as GC from '@grapecity/spread-sheets';
import '@grapecity/spread-sheets-designer';

//Apply License
GC.Spread.Sheets.LicenseKey = 'xxx';
GC.Spread.Sheets.Designer.LicenseKey = 'xxx';
```