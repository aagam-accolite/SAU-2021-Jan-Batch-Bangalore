import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Word } from '../Models/Word';
import { WordService } from '../word.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  words: Array<Word> = [];
  editableWord !: Word;
  showEditForm !: HTMLElement | null;

  optionsList: any = [
    "Word",
    "Meaning",
    "Part Of Speech",
    "Last Modified Time",
  ];
  form = new FormGroup({
    sortBy: new FormControl('', Validators.required)
  });

  patternForm = new FormGroup({
    pattern: new FormControl('', Validators.required)
  })

  constructor(private wordService: WordService) { }

  ngOnInit(): void {
    this.showEditForm = document.getElementById("edit-word")
    this.wordService.getAll().subscribe(resp => {
      console.log(resp);
      this.words = resp;
    })
  }

  reset() {
    this.wordService.getAll().subscribe(resp => {
      console.log(resp);
      this.words = resp;
    })
  }
  patternMatch() {
    console.log(this.patternForm.value);
    this.wordService.matchPattern(this.patternForm.value.pattern).subscribe(resp => {
      console.log(resp);
      if (resp) {
        this.words = resp;
      }
    })
  }
  edit(word: Word): void {
    console.log("edit", word);
    this.editableWord = word;
    if (this.showEditForm != null) {
      this.showEditForm.style.display = "block";
    }
  }
  delete(word: Word): void {
    console.log("delete", word);
    this.wordService.deleteWord(word.id).subscribe(resp => {
      console.log(resp);
      if (resp) {
        this.words = this.words.filter(oldWord => {
          word.id != oldWord.id;
        })
      }
      window.location.reload();

    });
  }

  updateWord($event: any): void {
    console.log($event);
    console.log("to be sent to update in backend");
    this.wordService.updateWord($event).subscribe(resp => {
      console.log(resp);
      if (this.showEditForm != null) {
        this.showEditForm.style.display = "none";
      }
      window.location.reload();
    });
  }

  sort() {
    console.log(this.form.value);

    switch (this.form.value.sortBy) {
      case "Word":
        this.words.sort((a, b) => a.word.localeCompare(b.word));
        break;
      case "Meaning":
        this.words.sort((a, b) => a.meaning.localeCompare(b.meaning));
        break;
      case "Part Of Speech":
        this.words.sort((a, b) => a.partOfSpeech.localeCompare(b.partOfSpeech));
        break;
      case "Last Modified Time":
        this.words.sort(function (a, b) { return new Date(a.lastModifiedTm).valueOf() - new Date(b.lastModifiedTm).valueOf(); });
        break;
    }
  }

}
