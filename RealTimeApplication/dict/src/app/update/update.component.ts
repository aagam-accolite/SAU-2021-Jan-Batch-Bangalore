import { Component, Input, OnChanges, OnInit, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Word } from '../Models/Word';
import { WordService } from '../word.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit, OnChanges {
  @Input('action') buttonLabel !: String;
  @Input('editableData') editableData!: Word;
  @Output() updateWord = new EventEmitter<any>();

  wordForm!: FormGroup;
  addWordPayload!: Word;
  id !: Number;
  constructor(private wordService: WordService, private router: Router) {
  }

  ngOnInit(): void {
    console.log("in update component");
    console.log(this.editableData);
    this.wordForm = new FormGroup({
      word: new FormControl(null, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
      meaning: new FormControl(null, (Validators.required, Validators.maxLength(150), Validators.minLength(10))),
      partOfSpeech: new FormControl(null, (Validators.required)),
      example: new FormControl("Example", (Validators.required)),
    });
  }
  addOrUpdateWord(): void {
    console.log("add or update word")
    console.log(this.wordForm);
    this.addWordPayload = this.wordForm.value;
    if (this.buttonLabel.includes("Update")) {
      console.log("in update if");
      this.updateWord.emit({
        ...this.wordForm.value,
        id: this.id,
      })
    } else {
      this.wordService.addWord(this.addWordPayload).subscribe(resp => {
        console.log(resp);
        this.router.navigate(['/home']);
      });
    }

  }
  ngOnChanges(changes: any) {
    if (changes.editableData && changes.editableData.currentValue != changes.editableData.previousValue) {
      this.wordForm = new FormGroup({
        word: new FormControl(this.editableData.word, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
        meaning: new FormControl(this.editableData.meaning, (Validators.required, Validators.maxLength(150), Validators.minLength(10))),
        partOfSpeech: new FormControl(this.editableData.partOfSpeech, (Validators.required)),
        example: new FormControl(this.editableData.example, (Validators.required)),
      });
      this.id = this.editableData.id;
    }
  }
}
