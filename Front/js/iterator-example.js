function createIterator(array){
    let index = 0;

    return {
        next: function(){
            return array[index++]
        },

        hasNext: function () {
            return index < array.length
        }
    }
}

let iterator = createIterator(['1', '2', '3']);
while (iterator.hasNext())  {
    console.log(iterator.next());
}