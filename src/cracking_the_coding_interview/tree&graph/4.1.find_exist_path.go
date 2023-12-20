package tree_graph

func findWhetherExistsPath2(n int, graph [][]int, start int, target int) bool {
	adjacentList := make([][]int, n)

	for _, link := range graph {
		src, dst := link[0], link[1]
		adjacentList[src] = append(adjacentList[src], dst)
	}

	visited := make([]bool, n)

	var dfs func(src int) bool
	dfs = func(src int) bool {
		visited[src] = true
		for _, adj := range adjacentList[src] {
			if adj == target {
				return true
			}
			if !visited[adj] && dfs(adj) {
				return true
			}
		}
		return false
	}
	return dfs(start)
}
