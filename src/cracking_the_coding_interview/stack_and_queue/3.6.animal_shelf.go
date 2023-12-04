package stack_and_queue

type AnimalShelf struct {
	data []int
}

func Constructor_6() AnimalShelf {
	return AnimalShelf{}

}

func (this *AnimalShelf) Enqueue(animal []int) {
	this.data = append(this.data, animal...)
}

func (this *AnimalShelf) DequeueAny() []int {
	if len(this.data) < 2 {
		return []int{-1, -1}
	}
	res := []int{this.data[0], this.data[1]}
	this.data = this.data[2:]
	return res
}

func (this *AnimalShelf) DequeueDog() []int {
	var index = 0
	for index < len(this.data) {
		if this.data[index+1] == 1 {
			res := []int{this.data[index], this.data[index+1]}
			this.data = append(this.data[:index], this.data[index+2:]...)
			return res
		}
		index = index + 2
	}

	return []int{-1, -1}
}

func (this *AnimalShelf) DequeueCat() []int {
	var index = 0
	for index < len(this.data) {
		if this.data[index+1] == 0 {
			res := []int{this.data[index], this.data[index+1]}
			this.data = append(this.data[:index], this.data[index+2:]...)
			return res
		}
		index = index + 2
	}
	return []int{-1, -1}

}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Enqueue(animal);
 * param_2 := obj.DequeueAny();
 * param_3 := obj.DequeueDog();
 * param_4 := obj.DequeueCat();
 */
