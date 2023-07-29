import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

export interface items{
  key:string, value: number
}

@Component({
  selector: 'app-custom-nutrition-recomendation',
  templateUrl: './custom-nutrition-recomendation.component.html',
  styleUrls: ['./custom-nutrition-recomendation.component.scss']
})
export class CustomNutritionRecomendationComponent implements OnChanges {
  ngOnChanges(): void {
    if (this.isSaved) {
      alert("saved");
      this.bagItemEvent.emit(this.bagItems);
    }
  }
  @Input()
  calorie: any;
  @Input()
  isSaved: any;
  @Output() variableEvent = new EventEmitter<number>();

  @Output()
  bagItemEvent = new EventEmitter();


  bagItems = {
    'chickenbreast': 0,
    'apple': 0,
    'bananas': 0,
    'berries': 0,
    'broccoli': 0,
    'brownrice': 0,
    'oats': 0,
    'quinoa': 0,
    'sweetpotatoes': 0,
    'wholegrainbread': 0,
    'almonds': 0,
    'avocado': 0,
    'cheesecheddar': 0,
    'chiaseeds': 0,
    'coconut': 0,
    'greekyogurt': 0,
    'oliveoil': 0,
    'peanutbutter': 0,
    'fillet': 0,
    'chickpeas': 0,
    'cottagecheese': 0,
    'eggs': 0,
    'lentils': 0,
    'salmon': 0,
    'tofu': 0,
    'turkeybreast': 0,
  }
  appear = false;
  totalcal = 0;


  addFood(val: string) {
    if (val.match("Apple")) {
      if (this.bagItems.apple == 0) {
        this.bagItems.apple = 1;
        console.log(this.bagItems.apple)
      }
      else {
        this.bagItems.apple = this.bagItems.apple + 1;
      }
    }

    if (val.match("Chicken Breast")) {
      if (this.bagItems['chickenbreast'] == 0) {
        this.bagItems['chickenbreast'] = 1;
        console.log(this.bagItems['chickenbreast'])
      }
      else {
        this.bagItems['chickenbreast'] = this.bagItems['chickenbreast'] + 1;
      }
    }

    if (val.match("Bananas")) {
      if (this.bagItems.bananas == 0) {
        this.bagItems.bananas = 1;
        console.log(this.bagItems.bananas)
      }
      else {
        this.bagItems.bananas = this.bagItems.bananas + 1;
      }
    }

    if (val.match("Berries")) {
      if (this.bagItems.berries == 0) {
        this.bagItems.berries = 1;
        console.log(this.bagItems.berries)
      }
      else {
        this.bagItems.berries = this.bagItems.berries + 1;
      }
    }

    if (val.match("Broccoli")) {
      if (this.bagItems.broccoli == 0) {
        this.bagItems.broccoli = 1;
        console.log(this.bagItems.broccoli)
      }
      else {
        this.bagItems.broccoli = this.bagItems.broccoli + 1;
      }
    }

    if (val.match("Brown rice")) {
      if (this.bagItems.brownrice == 0) {
        this.bagItems.brownrice = 1;
        console.log(this.bagItems.brownrice)
      }
      else {
        this.bagItems.brownrice = this.bagItems.brownrice + 1;
      }
    }

    if (val.match("Oats")) {
      if (this.bagItems.oats == 0) {
        this.bagItems.oats = 1;
        console.log(this.bagItems.oats)
      }
      else {
        this.bagItems.oats = this.bagItems.oats + 1;
      }
    }

    if (val.match("Quinoa")) {
      if (this.bagItems.quinoa == 0) {
        this.bagItems.quinoa = 1;
        console.log(this.bagItems.oats)
      }
      else {
        this.bagItems.quinoa = this.bagItems.quinoa + 1;
      }
    }

    if (val.match("Sweet Potatoes")) {
      if (this.bagItems.sweetpotatoes == 0) {
        this.bagItems.sweetpotatoes = 1;
        console.log(this.bagItems.sweetpotatoes)
      }
      else {
        this.bagItems.sweetpotatoes = this.bagItems.sweetpotatoes + 1;
      }
    }

    if (val.match("Whole Grain Bread")) {
      if (this.bagItems.wholegrainbread == 0) {
        this.bagItems.wholegrainbread = 1;
        console.log(this.bagItems.wholegrainbread)
      }
      else {
        this.bagItems.wholegrainbread = this.bagItems.wholegrainbread + 1;
      }
    }

    if (val.match("Chick Peas")) {
      if (this.bagItems.chickpeas == 0) {
        this.bagItems.chickpeas = 1;
        console.log(this.bagItems.chickpeas)
      }
      else {
        this.bagItems.chickpeas = this.bagItems.chickpeas + 1;
      }
    }

    if (val.match("Cottage Cheese")) {
      if (this.bagItems.cottagecheese == 0) {
        this.bagItems.cottagecheese = 1;
        console.log(this.bagItems.cottagecheese)
      }
      else {
        this.bagItems.cottagecheese = this.bagItems.cottagecheese + 1;
      }
    }

    if (val.match("Eggs")) {
      if (this.bagItems.eggs == 0) {
        this.bagItems.eggs = 1;
        console.log(this.bagItems.eggs)
      }
      else {
        this.bagItems.eggs = this.bagItems.eggs + 1;
      }
    }

    if (val.match("Greek Yogurt")) {
      if (this.bagItems.greekyogurt == 0) {
        this.bagItems.greekyogurt = 1;
        console.log(this.bagItems.greekyogurt)
      }
      else {
        this.bagItems.greekyogurt = this.bagItems.greekyogurt + 1;
      }
    }

    if (val.match("Lentils")) {
      if (this.bagItems.lentils == 0) {
        this.bagItems.lentils = 1;
        console.log(this.bagItems.lentils)
      }
      else {
        this.bagItems.lentils = this.bagItems.lentils + 1;
      }
    }

    if (val.match("Salmon")) {
      if (this.bagItems.salmon == 0) {
        this.bagItems.salmon = 1;
        console.log(this.bagItems.salmon)
      }
      else {
        this.bagItems.salmon = this.bagItems.salmon + 1;
      }
    }

    if (val.match("Tofu")) {
      if (this.bagItems.tofu == 0) {
        this.bagItems.tofu = 1;
        console.log(this.bagItems.tofu)
      }
      else {
        this.bagItems.tofu = this.bagItems.tofu + 1;
      }
    }

    if (val.match("Turkey Breast")) {
      if (this.bagItems.turkeybreast == 0) {
        this.bagItems.turkeybreast = 1;
        console.log(this.bagItems.turkeybreast)
      }
      else {
        this.bagItems.turkeybreast = this.bagItems.turkeybreast + 1;
      }
    }

    if (val.match("Almonds")) {
      if (this.bagItems.almonds == 0) {
        this.bagItems.almonds = 1;
        console.log(this.bagItems.almonds)
      }
      else {
        this.bagItems.almonds = this.bagItems.almonds + 1;
      }
    }

    if (val.match("Avocado")) {
      if (this.bagItems.avocado == 0) {
        this.bagItems.avocado = 1;
        console.log(this.bagItems.avocado)
      }
      else {
        this.bagItems.avocado = this.bagItems.avocado + 1;
      }
    }

    if (val.match("Cheese Cheddar")) {
      if (this.bagItems.cheesecheddar == 0) {
        this.bagItems.cheesecheddar = 1;
        console.log(this.bagItems.cheesecheddar)
      }
      else {
        this.bagItems.cheesecheddar = this.bagItems.cheesecheddar + 1;
      }
    }

    if (val.match("Chiaseeds")) {
      if (this.bagItems.chiaseeds == 0) {
        this.bagItems.chiaseeds = 1;
        console.log(this.bagItems.chiaseeds)
      }
      else {
        this.bagItems.chiaseeds = this.bagItems.chiaseeds + 1;
      }
    }

    if (val.match("Coconut Oil")) {
      if (this.bagItems.coconut == 0) {
        this.bagItems.coconut = 1;
        console.log(this.bagItems.coconut)
      }
      else {
        this.bagItems.coconut = this.bagItems.coconut + 1;
      }
    }



    if (val.match("Olive Oil")) {
      if (this.bagItems.oliveoil == 0) {
        this.bagItems.oliveoil = 1;
        console.log(this.bagItems.oliveoil)
      }
      else {
        this.bagItems.oliveoil = this.bagItems.oliveoil + 1;
      }
    }

    if (val.match("Peanut Butter")) {
      if (this.bagItems.peanutbutter == 0) {
        this.bagItems.peanutbutter = 1;
        console.log(this.bagItems.peanutbutter)
      }
      else {
        this.bagItems.peanutbutter = this.bagItems.peanutbutter + 1;
      }
    }

    if (val.match("Fillet")) {
      if (this.bagItems.fillet == 0) {
        this.bagItems.fillet = 1;
        console.log(this.bagItems.fillet)
      }
      else {
        this.bagItems.fillet = this.bagItems.fillet + 1;
      }
    }

    this.totalcal = this.bagItems.apple * 190 + this.bagItems.bananas * 120 + this.bagItems.berries * 80 + this.bagItems.broccoli * 50 + this.bagItems.brownrice * 115 + this.bagItems.oats * 170 + this.bagItems.quinoa * 125 + this.bagItems.sweetpotatoes * 130 + this.bagItems.wholegrainbread * 90 + this.bagItems.almonds * 190 + this.bagItems.avocado * 100 + this.bagItems.cheesecheddar * 120 + this.bagItems.chiaseeds * 70 + this.bagItems.coconut * 130 + this.bagItems.greekyogurt * 150 + this.bagItems.oliveoil * 130 + this.bagItems.peanutbutter * 200 + this.bagItems.fillet * 350 + this.bagItems['chickenbreast'] * 190 + this.bagItems.chickpeas * 180 + this.bagItems.cottagecheese * 120 + this.bagItems.eggs * 80 + this.bagItems.lentils * 230 + this.bagItems.salmon * 350 + this.bagItems.tofu * 100 + this.bagItems.turkeybreast * 170,
      this.variableEvent.emit(this.totalcal);

  }

  minusFood(val: string) {
    if (val.match("Apple")) {
      if (this.bagItems.apple == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.apple = this.bagItems.apple - 1;
      }
    }

    if (val.match("Chicken Breast")) {
      if (this.bagItems['chickenbreast'] == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems['chickenbreast'] = this.bagItems['chickenbreast'] - 1;
      }
    }

    if (val.match("Bananas")) {
      if (this.bagItems.bananas == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.bananas = this.bagItems.bananas - 1;
      }
    }

    if (val.match("Berries")) {
      if (this.bagItems.berries == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.berries = this.bagItems.berries - 1;
      }
    }

    if (val.match("Broccoli")) {
      if (this.bagItems.broccoli == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.broccoli = this.bagItems.broccoli - 1;
      }
    }

    if (val.match("Brown rice")) {
      if (this.bagItems.brownrice == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.brownrice = this.bagItems.brownrice - 1;
      }
    }

    if (val.match("Oats")) {
      if (this.bagItems.oats == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.oats = this.bagItems.oats - 1;
      }
    }

    if (val.match("Quinoa")) {
      if (this.bagItems.quinoa == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.quinoa = this.bagItems.quinoa - 1;
      }
    }

    if (val.match("Sweet Potatoes")) {
      if (this.bagItems.sweetpotatoes == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.sweetpotatoes = this.bagItems.sweetpotatoes - 1;
      }
    }

    if (val.match("Whole Grain Bread")) {
      if (this.bagItems.wholegrainbread == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.wholegrainbread = this.bagItems.wholegrainbread - 1;
      }
    }

    if (val.match("Chick Peas")) {
      if (this.bagItems.chickpeas == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.chickpeas = this.bagItems.chickpeas - 1;
      }
    }

    if (val.match("Cottage Cheese")) {
      if (this.bagItems.cottagecheese == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.cottagecheese = this.bagItems.cottagecheese - 1;
      }
    }

    if (val.match("Eggs")) {
      if (this.bagItems.eggs == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.eggs = this.bagItems.eggs - 1;
      }
    }

    if (val === "Greek Yogurt") {
      if (this.bagItems.greekyogurt == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.greekyogurt = this.bagItems.greekyogurt - 1;
      }
    }

    if (val.match("Lentils")) {
      if (this.bagItems.lentils == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.lentils = this.bagItems.lentils - 1;
      }
    }

    if (val.match("Salmon")) {
      if (this.bagItems.salmon == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.salmon = this.bagItems.salmon - 1;
      }
    }

    if (val.match("Tofu")) {
      if (this.bagItems.tofu == 0) {

      }
      else {
        this.bagItems.tofu = this.bagItems.tofu - 1;
      }
    }

    if (val.match("Turkey Breast")) {
      if (this.bagItems.turkeybreast == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.turkeybreast = this.bagItems.turkeybreast - 1;
      }
    }

    if (val.match("Almonds")) {
      if (this.bagItems.almonds == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.almonds = this.bagItems.almonds - 1;
      }
    }

    if (val.match("Avocado")) {
      if (this.bagItems.avocado == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.avocado = this.bagItems.avocado - 1;
      }
    }

    if (val.match("Cheese Cheddar")) {
      if (this.bagItems.cheesecheddar == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.cheesecheddar = this.bagItems.cheesecheddar - 1;
      }
    }

    if (val.match("Chiaseeds")) {
      if (this.bagItems.chiaseeds == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.chiaseeds = this.bagItems.chiaseeds - 1;
      }
    }

    if (val.match("Coconut Oil")) {
      if (this.bagItems.coconut == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.coconut = this.bagItems.coconut - 1;
      }
    }



    if (val.match("Olive Oil")) {
      if (this.bagItems.oliveoil == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.oliveoil = this.bagItems.oliveoil - 1;
      }
    }

    if (val.match("Peanut Butter")) {
      if (this.bagItems.peanutbutter == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.peanutbutter = this.bagItems.peanutbutter - 1;
      }
    }

    if (val.match("Fillet")) {
      if (this.bagItems.fillet == 0) {
        alert("Invalid");
      }
      else {
        this.bagItems.fillet = this.bagItems.fillet - 1;
      }
    }


    this.totalcal = this.bagItems.apple * 190 + this.bagItems.bananas * 120 + this.bagItems.berries * 80 + this.bagItems.broccoli * 50 + this.bagItems.brownrice * 115 + this.bagItems.oats * 170 + this.bagItems.quinoa * 125 + this.bagItems.sweetpotatoes * 130 + this.bagItems.wholegrainbread * 90 + this.bagItems.almonds * 190 + this.bagItems.avocado * 100 + this.bagItems.cheesecheddar * 120 + this.bagItems.chiaseeds * 70 + this.bagItems.coconut * 130 + this.bagItems.greekyogurt * 150 + this.bagItems.oliveoil * 130 + this.bagItems.peanutbutter * 200 + this.bagItems.fillet * 350 + this.bagItems['chickenbreast'] * 190 + this.bagItems.chickpeas * 180 + this.bagItems.cottagecheese * 120 + this.bagItems.eggs * 80 + this.bagItems.lentils * 230 + this.bagItems.salmon * 350 + this.bagItems.tofu * 100 + this.bagItems.turkeybreast * 170;
    this.variableEvent.emit(this.totalcal);

  }

}
