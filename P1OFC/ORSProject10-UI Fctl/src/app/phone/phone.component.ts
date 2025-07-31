import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.css']
})
export class PhoneComponent extends BaseCtl {
  errorMessageTitle: string = '';
  errorMessageName: string = '';
  errorMessagePrice: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.PHONE, locator, route);
  }

  // Validate required fields
  validateForm(form): boolean {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.os);
    flag = flag && validator.isNotNullObject(form.modelName); // ✅ modelName used correctly
    flag = flag && validator.isNotNullObject(form.launchDate);
    flag = flag && validator.isNotNullObject(form.price);
    return flag;
  }

  // Populate form data from backend
  populateForm(form, data) {
    form.id = data.id;
    form.launchDate = data.launchDate;
    form.modelName = data.modelName; // ✅ keep modelName
    form.os = data.os;
    form.price = data.price;
  }

  // Validate model name input
  validateName(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    const alphabetPattern = /^[a-zA-Z\s]*$/;

    if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageName = 'Only alphabets are allowed.';
      return;
    }

    if (inputValue.length > 50) {
      this.errorMessageName = 'Model name must not exceed 50 characters.';
    } else {
      this.errorMessageName = '';
    }
  }

  // Optional pre-save validation
  validateBeforeSave(): boolean {
    if (this.errorMessageName || this.errorMessagePrice) {
      return false;
    }
    return this.validateForm(this.form.data);
  }

  // Custom save method
  saveForm(): void {
    if (this.validateBeforeSave()) {
      console.log('Form is valid. Saving...');
      // Save logic here
    } else {
      console.log('Form invalid. Save aborted.');
    }
  }
}
