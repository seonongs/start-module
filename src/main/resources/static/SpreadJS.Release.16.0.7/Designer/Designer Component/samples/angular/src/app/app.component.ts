import { Component, ViewEncapsulation } from '@angular/core';
import * as GC from '@grapecity/spread-sheets';
import "@grapecity/spread-sheets-print";
import "@grapecity/spread-sheets-shapes";
import "@grapecity/spread-sheets-slicers";
import "@grapecity/spread-sheets-pivot-addon";
import "@grapecity/spread-sheets-tablesheet";
import "@grapecity/spread-sheets-io";
import '@grapecity/spread-sheets-designer-resources-en';
import '@grapecity/spread-sheets-designer';
import * as GCDesigner from "@grapecity/spread-sheets-designer";

import * as ExcelIO from '@grapecity/spread-excelio';
 
// var sjsLicense = "sjs-distribution-key";
// GC.Spread.Sheets.LicenseKey = sjsLicense;
// (ExcelIO as any).LicenseKey = sjsLicense;
 
// (GC.Spread.Sheets as any).Designer.LicenseKey = "designer-component-distribution-key”;

var config = GCDesigner.Spread.Sheets.Designer.DefaultConfig;
config.commandMap = {
  Welcome: {
    title: "Welcome",
    text: "Welcome",
    iconClass: "ribbon-button-welcome",
    bigButton: true,
    commandName: "Welcome",
    execute: async (context: GCDesigner.Spread.Sheets.Designer.Designer, propertyName: string, fontItalicChecked: boolean) => {
      alert("Welcome to new designer.");
    },
  },
};
config.ribbon[0].buttonGroups.unshift({
  label: "NewDesigner",
  thumbnailClass: "welcome",
  commandGroup: {
    children: [
      {
        direction: "vertical",
        commands: ["Welcome"],
      },
      // This is custom button ----------------end-------------
    ],
  },
});
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {
  title = 'en';
  props = {
    styleInfo: "width: 100%; height: 98vh; margin-top: 10px",
    config: config,
    spreadOptions: { sheetCount: 2 }
  };
}
